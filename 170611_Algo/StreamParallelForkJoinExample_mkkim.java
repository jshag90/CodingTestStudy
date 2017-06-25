package parallel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamParallelForkJoinExample_mkkim {

	/**
	 *  ForkJoin 프레임워크는 자바에서 병렬처리를 지원하는 프레임워크로 새롭게 소개된 개념이 아니라
	 *  Java 7 부터 포함된 개념입니다.
	 *  하나의 작업을 여러개의 작은 Task로 split 한 다음이 Task를 fork하여
	 *  (물리적인 프로세스로 fork 하는 것이 아니라 실제로는 Thread) 병렬로 처리하고 각 Task의 수행된
	 *  결과를 병합하기 위해 join 단계를 실행하는 프레임워크이다.
	 *  
	 *  
	 *  Stream의 경우 element의 전체 size를 알수 없는 경우도 많기 때문에
	 *  단순히 분할하는 것이 쉽지 않다. 이것을 위한 기능이 Spliterator의 trySplit 메소드이다.
	 *  Spliterator는 클래스명으로부터 그 기능을 유추해 볼수 있는데, 
	 *  Split 되는 Iterator이다. trySplit() 메소드에서는 Stream을 병렬 처리할 수 있는 단위로 분할한다.
	 *  tryAdvance() 메소드에서 각 element를 소비하는 기능을 수행한다. 소비한다는 의미는 실제 Stream으로 부터 데이터를
	 *  읽어서 Consumer를 호출한다는 의미이다. 
	 *  
	 */
	
	public static void main (String[] args) throws Exception {
	  
	  long par_start = System.currentTimeMillis();
	  ArrayList<String> list = new ArrayList();
	  
	  String FILE_PATH = "D:/algorithm_workspace/algorithm_1.txt"; 
	  try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH)))) {
	    //MultiLineSpliterator spliterator = new MultiLineSpliterator(reader, batchSize, taskLineNum);
		Stream<String> stream = Files.lines(Paths.get(FILE_PATH));
	    
	    ForkJoinPool myPool = new ForkJoinPool(4);
	    myPool.submit(() -> {

	    stream.parallel().forEach( s  ->  {
	    	//System.out.println("Starting " + Thread.currentThread().getName() + ", index=" + s + ", " + new Date());
	    		if(s.indexOf("imap") > -1) {
	    			list.add(s);

	    		}	
	    });
	    }).get();
	    System.out.println("검색된 개수" + list.size());
	    long par_end = System.currentTimeMillis();

		System.out.println("실행시간" + (par_end - par_start) / 1000.0);
	  } catch (FileNotFoundException e) {
	    e.printStackTrace();
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
	}  
	
	
	private List<Integer> findIndex(String s,String inputStr) {
		String SPLIT_STR = "[:=_-[,]_]";
		String[] sList = s.split(SPLIT_STR);
		List<Integer> resultList = new ArrayList<Integer>();
		for (int i = 0; i < sList.length; i++) {
			if(sList[i].indexOf(inputStr) > -1) {
				resultList.add(i);
			}
		}
		
		return resultList;	
	}
	
}

class MultiLineSpliterator implements Spliterator<List<String>> {
    List<String> lines;
    int lineBuffSize;
    int batchSize;
    BufferedReader reader;
    Iterator<String> it;
 
    public MultiLineSpliterator(BufferedReader reader, int lineBuffSize, int batchSize) {
      this.reader = reader;
      this.lineBuffSize = lineBuffSize;
      this.batchSize = batchSize;
      this.lines = new ArrayList<>(lineBuffSize);
    }
 
    @Override
    public boolean tryAdvance(Consumer<? super List<String>> action) {
      if (it == null) {
        it = lines.iterator();
      }
      List<String> batchList = new ArrayList<>(batchSize);
      int count = 0;
      while (it.hasNext()) {
        batchList.add(it.next());
        count++;
        if (count >= batchSize) break;
      }
      action.accept(batchList);
      return it.hasNext();
    }
 
    @Override
    public Spliterator<List<String>> trySplit() {
      try {
        String line;
        while ((line = reader.readLine()) != null) {
          lines.add(line);
          if (lines.size() >= lineBuffSize) {
            return new MultiLineSpliterator(reader, lineBuffSize, batchSize);
          }
        }
        if (lines.isEmpty()) {
          return null;
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      return null;
    }
 
    @Override
    public long estimateSize() {
      return lines.isEmpty() ? Long.MAX_VALUE : lines.size();
    }
 
    @Override
    public int characteristics() {
      return IMMUTABLE;
    }
}