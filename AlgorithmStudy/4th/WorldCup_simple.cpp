/* -----------------------------------------------------------------------
���� ����:
	6���� ���� ���� 5���� ��⸦ �ϴ� �� ������ 15��
	�ߺ������� �̿�, 3^15���� ����� ���� ����
	������ ��� ��,��,���� ����� ���� ���ߴ�

	�� ���, ����� ���� �ʹ� Ŀ �ð� �ʰ� (9��) �� ����.

	�̿� 5�� ��, ���� 4���� ��⿡ ���Ͽ� (�� 10���� ���) �ߺ������� �̿�,
	3^10���� ����� ���� ���� ��, �̸� �ؽ��¿� ����� �ξ���.

	�׸��� ����� �־����� 6�� ���� ������ ���Ͽ�, ������ ���� �� ������
	�Ұ��� �� (�� �¹��и� ��� ������ ���� ���Ŀ� ���� 5!���� ����� ���� ����),
	�̵� 5�� ���� ������ ���Ͽ� �ڵ带 ���Ͽ� ������ �ؽ��¿� ����, ��ȿ���� �����ߴ�.
--------------------------------------------------------------------------
���� �ν�:
	���� �̷��� 3^15 -> 3^10 ����� ���� ���̱� ���� �ҰŹ��� ����غ���
	ó������ �ҰŹ��� ���� �Ǿ��ٴ� ���� �˰� �Ǿ���.
--------------------------------------------------------------------------
�ذ�å:
	����κ��� �־����� 6�� ���� ������, ������ 1�� ���� ���� ������ ��� �Ұ��Ѵ�.
	������ �� �� ���� ���� ������ ��, �� �� ���� ����ϵ� ������ 
	(��, ��, �а� ��� 0) ��ȿ�� ������ �����Ѵ�.

	�Ź� �ҰŽø���, �ҰŵǴ� ���� ��� ����� ��� ������ ���� �����Ŀ� ���� 
	N!�� ����� ���� �����. ��, 6! X 5! X 4! X 3! X 2! �� ������ �ʿ��� ���̴�.
--------------------------------------------------------------------------
���: 
	���� - 0.1��, �˰����� ������������ ����ð��� �� �þ��.
	�ƹ����� 3^10 X 6! ���� 6! X 5! X 4! X 3! X 2! �� �� ū ���ΰ� ����.
----------------------------------------------------------------------- */

#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

/* ------------------------------------------------------------
	CASE_GENERATOR
------------------------------------------------------------ */
/**
 * ����� �� �� N! ������
 */
class FactorialGenerator
{
private:
	/**
	 * �� ���Ұ� ���� �� �ִ� ���� ������ �ڸ� ��
	 */
	size_t n;

	/**
	 * ������ ��� ����� �� ����.
	 */
	size_t size_;

	/**
	 * 1 ~ n���� ��Ƶ� ���� �迭. 
	 * ������ ���� ���� �迭�̴�.
	 */
	vector<size_t> atomArray;

public:
	FactorialGenerator(size_t n)
	{
		this->n = n;

		size_ = n;
		for (size_t i = n - 1; i >= 1; i--)
			size_ *= i;

		atomArray.assign(n, 0);
		for (size_t i = 0; i < n; i++)
			atomArray[i] = i;
	};

	auto size() const -> size_t
	{
		return size_;
	};

	/**
	 * Index��° ����� ���� �޾ƿ´�.
	 */
	auto at(size_t index) const -> vector<size_t>
	{
		// �ϴ� 0 ~ n-1 ���� ��ȣ�� ��� ���� �迭�� �����
		vector<size_t> atomArray = this->atomArray;
		vector<size_t> row(n, 0);

		for (size_t i = 0; i < n; i++)
		{
			size_t item = index % atomArray.size(); // index�� ���� ������ �������� �޾ƿ�
			row[i] = atomArray[item]; // �� ��ȣ��� ����� ���� Ȯ����

			index = index / atomArray.size(); // ���� ������ ���� index�� ����
			atomArray.erase(atomArray.begin() + item); // ���� ����� ��ȣ item�� ����
		}

		return row;
	};
};

/* ------------------------------------------------------------
	WORLD_CUP
------------------------------------------------------------ */
enum Game : int
{
	WIN = 1,
	DRAW = 0,
	LOSS = -1
};

class WorldCup;

class Team
{
	friend class WorldCup;

private:
	int win;
	int draw;
	int loss;

public:
	Team() 
	{
		win = 0;
		draw = 0;
		loss = 0;
	};

private:
	/**
	 * �ش�Ǵ� ������ ī��Ʈ�� 1 ��ŭ ���δ�.
	 * ���⼭ ������ �߻��ϸ�, �ش� ������ ������ ��ȿ���� ���� ������ ���ֵ�.
	 */
	void erase(int game)
	{
		int &count = (game == Game::WIN) ? win : (game == Game::DRAW) ? draw : loss;
		count--;
	};

	/**
	 * ���� ���� ������ ��ȿ�Ѱ�.
	 *
	 * ��, ��, ���� ���� �߿� ������ ���ڰ� ������ ��ȿ�� ������ ����.
	 */
	auto isValid() const -> bool
	{
		return win >= 0 && draw >= 0 && loss >= 0;
	};
};

/**
 * �� ȸ�� ������.
 *
 * �� ���� ������ ���� Team ��ü���� �����Ѵ�.
 */
class WorldCup
	: public vector<Team>
{
private:
	typedef vector<Team> super;

	static const size_t TEAM_SIZE = 6;
	static const size_t GAME_SIZE = TEAM_SIZE - 1;

public:
	using super::super;

	/**
	 * Default Constructor.
	 *
	 * �� ȸ �������� ������ �Է¹޾� �����͸� �����Ѵ�.
	 */
	WorldCup()
		: super()
	{
		// ����κ��� �� ���� ������ �Է¹���
		this->assign(TEAM_SIZE, Team());
		for (size_t i = 0; i < size(); i++)
		{
			Team &team = this->at(i);

			cin >> team.win;
			cin >> team.draw;
			cin >> team.loss;
		}
	};

	auto isValid() const -> bool
	{
		if (size() == 1)
		{
			// �ҰŸ� �ŵ��� ����, �� �� ���� ���� ���Ҵٸ�
			const Team &team = this->front();

			// �ƹ��� ������ ���� ���� �˻��� �� ������ ��ȿ�� ���θ� Ȯ�����´�.
			return (team.win == 0 && team.draw == 0 && team.loss == 0);
		}

		// ���� ��ȿ�� ����
		bool hasNegative =
			std::any_of // �� �ϳ���
			(
				this->begin(), this->end(), // ���� ������ �����
				[](const Team &team) -> bool // �� ���� �������κ���
				{
					//��ȿ���� ���� ����� �߰ߵǸ� (������ ���� in ��, �� or ��)
					return team.isValid() == false;
				}
			);
		if (hasNegative == true)
			return false; // �ٷ� ��ȿ�� ������ �����Ѵ�.

		for (size_t i = 0; i < size(); i++)
			if (this->at(i).isValid() == false)
				return false;

		// �� ���� ������ ��ȿ�� ����� ���ٸ�,
		// ������ ���� �� ��⸦ �Ұ��� �������� ���� ��� �˻��� �������Ѵ�.
		const Team &lastTeam = this->back();
		vector<int> gameArray;

		// ���� ����� ����س���
		gameArray.insert(gameArray.end(), (size_t)lastTeam.win, Game::WIN);
		// ������ ���� �¸� Ƚ����ŭ, Game::WIN�� gameArray�� �Է��Ѵٴ� �ǹ��̴�.
		gameArray.insert(gameArray.end(), (size_t)lastTeam.draw, Game::DRAW);
		gameArray.insert(gameArray.end(), (size_t)lastTeam.loss, Game::LOSS);

		// �� �����κ��� ������ ������ ��� ����� �Ұ��ؾ� �ϴµ�
		// ��� ��⸦ ��� �����κ��� �Ұ��� ��, �� N! ���� ����� ���� �����
		FactorialGenerator caseGenerator(gameArray.size());
		for (size_t i = 0; i < caseGenerator.size(); i++)
		{
			// ������ ���� ���� ������ ������ ����� ���� ��
			WorldCup worldCup(*this);
			worldCup.pop_back();

			// �� ����� ���κ���
			const vector<size_t> &row = caseGenerator.at(i);

			// ������ ���� �� ��� ��ϵ��� �Ұ���
			for (size_t j = 0; j < row.size(); j++)
			{
				Team &team = worldCup[row[j]];
				int game = gameArray[j];

				// ������ ���� �̰�����, �ٸ� �������� �й踦 �����
				// ������ ���� ������, �ٸ� �������� �¸��� ������ �ϱ⿡ X -1
				team.erase(game * -1);
			}

			// �ش� ������ ����� ��ȿ�ϴٸ�, �ٷ� ��ȿ�ϴ� ����
			if (worldCup.isValid() == true)
				return true;
		}

		// ��� ��ϵ� ��ȿ���� ���ߴٸ�, ���� ��ȿ���� ���� ����.
		return false;
	};
};

int main()
{
	for (size_t i = 0; i < 4; i++)
	{
		WorldCup worldCup;

		cout << worldCup.isValid() << " ";
	}

#ifdef _WIN32
	system("pause");
#endif
	return 0;
}