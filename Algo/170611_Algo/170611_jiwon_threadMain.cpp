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

#include <Windows.h> 
LARGE_INTEGER Frequency;
LARGE_INTEGER BeginTime;
LARGE_INTEGER Endtime;


#include "TextParser.h"

using namespace std;

int main()
{
	TextParser* tp = new TextParser();

	ifstream inFile("C:\\Users\\jwon\\Desktop\\test2.txt");
	int lineIndex = 0;
	string searchWord = "imap";
	string textLine;


	//프로그램이나 클래스 시작부분에
	QueryPerformanceFrequency(&Frequency);

	//사용하고자 하는 부분에
	QueryPerformanceCounter(&BeginTime);

#pragma omp parallel 
{
	while (getline(inFile, textLine)) {
		tp->stringFind(searchWord, textLine, lineIndex);
		lineIndex++;
	}
}

	QueryPerformanceCounter(&Endtime);
	__int64 elapsed = Endtime.QuadPart - BeginTime.QuadPart;
	double duringtime = (double)elapsed / (double)Frequency.QuadPart;
	cout << "수행시간 : " << duringtime << endl;

	inFile.close();

	system("pause");
	return 0;
}