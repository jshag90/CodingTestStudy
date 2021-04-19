#include <iostream>
#include <string>
#include <map>
#include <fstream>
#include <istream>
#include <vector>
#include <regex>
#include <boost/algorithm/string/trim.hpp>
#include <boost/regex.hpp>
#include <boost/tokenizer.hpp>
#include <boost/thread/thread.hpp>
#include <boost/bind.hpp>

#include "TextParser.h"

/*parallel library*/
#include <ppl.h>
//#include <tbb\tbb.h> 
#include <omp.h>
#include <boost/thread.hpp>  
#include <boost/bind.hpp>

using namespace std;
using namespace Concurrency;


void TextParser::stringFind(string searchWord, string textLine, int lineIndex)
{
	multimap <int, multimap<int, string>>::iterator kiter;

	multimap <int, string> valueMap;
	multimap<int, string>::iterator viter;

	boost::regex regexPattern("[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]");

	const boost::regex_token_iterator<string::const_iterator> end;
	int vcount = 0;



#pragma omp parallel 
{
	//#pragma omp parallel for
	for (boost::regex_token_iterator<string::const_iterator> i(textLine.begin(), textLine.end(), regexPattern, -1); i != end; ++i) // iterator는 non-safaty thread 이므로 사용 X
	{
		string stemp = i->str();
		boost::trim(stemp);

		valueMap.insert({ vcount, stemp });

		keyMap.insert(pair<int, multimap<int, string>>(lineIndex, valueMap));
		vcount++;

	}
}
	//#pragma omp parallel for
	for (viter = valueMap.begin(); viter != valueMap.end(); ++viter) {
		cout << "[" << lineIndex << "," << (*viter).first << "] : " << (*viter).second << endl;


		if ((*viter).second == searchWord) {
			cout << " =========== searchWord =========== ";
			cout << searchWord << " 의 위치: [" << lineIndex << "," << (*viter).first << "]" << endl;

		}
	}


}


