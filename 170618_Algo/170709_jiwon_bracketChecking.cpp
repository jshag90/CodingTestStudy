
//[문제] 수식이 문자열의 형태로 주어지면, 해당 수식의 괄호 짝이 맞는지 판단하는 프로그램을 작성하시오.
// 괄호의 종료 : (), {}. []
//[{1+3}/(2-4)]

#include <iostream>
#include <string>

using namespace std;

void push(char input);
void print(void);
char pop(void);
char peek(void);
void del(void);
int isEmpty(void);
int getSize(void);

#define STACK_SIZE 100
char stack[STACK_SIZE]; //스택(배열) 생성
int top = -1; //스택의 가장 마지막 데이터 위치

int main(void)
{
	char str[100]; //수식을 입력 받을 배열
	int i, len;
	char ch;

	cout << "수식을 입력하세요: ";
	cin >> str;

	len = strlen(str);

	for (i = 0; i < len; i++)
	{
		if (str[i] == '(' || str[i] == '{' || str[i] == '[')
			push(str[i]);
		else if (str[i] == ')')
		{
			if (isEmpty())
			{
				cout << "괄호가 맞지 않습니다." << endl;
				system("pause");
				return -1;
			}
			ch = pop();
			if (ch != '(')
			{
				cout << "괄호가 맞지 않습니다." << endl;
				system("pause");
				return -1;
			}

		}
		else if (str[i] == '}')
		{
			if (isEmpty())
			{
				cout << "괄호가 맞지 않습니다." << endl;
				system("pause");
				return -1;
			}
			ch = pop();
			if (ch != '{')
			{
				cout << "괄호가 맞지 않습니다." << endl;
				system("pause");
				return -1;
			}

		}
		else if (str[i] == ']')
		{
			if (isEmpty())
			{
				cout << "괄호가 맞지 않습니다." << endl;
				system("pause");
				return -1;
			}
			ch = pop();
			if (ch != '[')
			{
				cout << "괄호가 맞지 않습니다." << endl;
				system("pause");
				return -1;
			}
		}
	}
	if (!isEmpty())
	{
		cout << "괄호가 맞지 않습니다." << endl;
		system("pause");
		return -1;
	}

	system("pause");
	return 0;
}


void push(char input)
{
	if (top >= (STACK_SIZE - 1)) //스택이 가득차면, 더이상 삽입이 불가능함
		return;
	stack[++top] = input; //스택에 데이터 삽입

}


void print(void)
{
	int i;
	//스택 전체를 출력
	cout << "<Stack>" << endl;
	for (i = 0; i < top; i++)
		cout << stack[i] << endl;

}

char pop(void)
{
	if (top == -1) //스택이 비어있는 경우에는 pop을 할 수 없음
	{
		cout << "Empty !" << endl;
		exit(0);
	}
	return stack[top--]; //가장 마지막에 들어온 데이터를 반환
}

char peek(void)
{
	if (top == -1) //스택이 비어있는 경우에는 peek을 할 수 없음
	{
		cout << "Empty !" << endl;
		exit(0);
	}
	return stack[top]; //가장 마지막에 들어온 데이터를 반환
}


void del(void)
{
	if (top == -1) //스택이 비어있는 경우에는 peek을 할 수 없음
	{
		cout << "Empty !" << endl;
		return;
	}
	top--;
}

int isEmpty(void)
{
	if (top == -1) //스택이 비어 있음
		return 1; //True
	else //스택이 비어있지 않음
		return 0; //False
}

int getSize(void)
{
	return top + 1; //현재 스택의 데이터 개수를 반환 
}