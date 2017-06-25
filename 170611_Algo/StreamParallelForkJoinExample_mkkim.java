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
	 *  ForkJoin �����ӿ�ũ�� �ڹٿ��� ����ó���� �����ϴ� �����ӿ�ũ�� ���Ӱ� �Ұ��� ������ �ƴ϶�
	 *  Java 7 ���� ���Ե� �����Դϴ�.
	 *  �ϳ��� �۾��� �������� ���� Task�� split �� ������ Task�� fork�Ͽ�
	 *  (�������� ���μ����� fork �ϴ� ���� �ƴ϶� �����δ� Thread) ���ķ� ó���ϰ� �� Task�� �����
	 *  ����� �����ϱ� ���� join �ܰ踦 �����ϴ� �����ӿ�ũ�̴�.
	 *  
	 *  
	 *  Stream�� ��� element�� ��ü size�� �˼� ���� ��쵵 ���� ������
	 *  �ܼ��� �����ϴ� ���� ���� �ʴ�. �̰��� ���� ����� Spliterator�� trySplit �޼ҵ��̴�.
	 *  Spliterator�� Ŭ���������κ��� �� ����� ������ ���� �ִµ�, 
	 *  Split �Ǵ� Iterator�̴�. trySplit() �޼ҵ忡���� Stream�� ���� ó���� �� �ִ� ������ �����Ѵ�.
	 *  tryAdvance() �޼ҵ忡�� �� element�� �Һ��ϴ� ����� �����Ѵ�. �Һ��Ѵٴ� �ǹ̴� ���� Stream���� ���� �����͸�
	 *  �о Consumer�� ȣ���Ѵٴ� �ǹ��̴�. 
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
	    System.out.println("�˻��� ����" + list.size());
	    long par_end = System.currentTimeMillis();

		System.out.println("����ð�" + (par_end - par_start) / 1000.0);
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