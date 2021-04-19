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

using namespace std;

void stringFind(string searchWord, string textLine, int lineIndex)
{
	multimap <int, multimap<int, string>> keyMap;
	multimap <int, multimap<int, string>>::iterator kiter;

	multimap <int, string> valueMap;
	multimap<int, string>::iterator viter;

	boost::regex regexPattern("[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]");

	const boost::regex_token_iterator<string::const_iterator> end;
	int vcount = 0;

	for (boost::regex_token_iterator<string::const_iterator> i(textLine.begin(), textLine.end(), regexPattern, -1); i != end; ++i)
	{
		string stemp = i->str();
		boost::trim(stemp);

		valueMap.insert({ vcount, stemp });

		keyMap.insert(pair<int, multimap<int, string>>(lineIndex, valueMap));
		vcount++;

	}

	cout << "<result>: " << endl;

	for (viter = valueMap.begin(); viter != valueMap.end(); ++viter){
		cout << "[" << lineIndex << "," << (*viter).first << "] : " << (*viter).second << endl;

		if ((*viter).second == searchWord ) {
			cout << " =========== searchWord =========== ";
			cout << searchWord << " 의 위치: [" << lineIndex << "," << (*viter).first << "]" << endl;

		}
	}

}

int main()
{

	ifstream inFile("C:\\Users\\jwon\\Desktop\\test.txt");
	int lineIndex = 0;
	string searchWord = "imap";
	string textLine;

	while (getline(inFile, textLine)) {

		stringFind(searchWord, textLine, lineIndex);
		lineIndex++;
	}

	inFile.close();

	system("pause");
	return 0;
}
