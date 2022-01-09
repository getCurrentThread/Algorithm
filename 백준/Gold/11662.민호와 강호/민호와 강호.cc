#include <iostream>
#include <cmath>


using namespace std;

struct Point {
	double x;
	double y;
};

double pow2(const double num) {
	return  num * num;
}

//left 점들 사이의 거리가 mid점 보다 더 멀다면 true.
bool isCheck(const Point& Al, const Point& Am, const Point& Bl, const Point& Bm) {
	return (pow2(Al.x - Bl.x) + pow2(Al.y - Bl.y)) > 
		   (pow2(Am.x - Bm.x) + pow2(Am.y - Bm.y));
}

int main() {
	int ax, ay, bx, by, cx, cy, dx, dy;

	cin >> ax >> ay >> bx >> by >> cx >> cy >> dx >> dy;
	Point Al, Ar, Bl, Br;
	Al.x = ax; Ar.x = bx; Bl.x = cx; Br.x = dx;
	Al.y = ay; Ar.y = by; Bl.y = cy; Br.y = dy;

	Point Am, Bm;
	Point Ap, Aq;
	Point Bp, Bq;
	Ap.x = (2 * Al.x + Ar.x) / 3.; Ap.y = (2 * Al.y + Ar.y) / 3.;
	Aq.x = (Al.x + 2 * Ar.x) / 3.; Aq.y = (Al.y + 2 * Ar.y) / 3.;
	Bp.x = (2 * Bl.x + Br.x) / 3.; Bp.y = (2 * Bl.y + Br.y) / 3.;
	Bq.x = (Bl.x + 2 * Br.x) / 3.; Bq.y = (Bl.y + 2 * Br.y) / 3.;

	while (abs(Al.x - Ar.x) > 0.00000001 || abs(Al.y - Ar.y) > 0.00000001
		|| abs(Bl.x - Br.x) > 0.00000001 || abs(Bl.y - Br.y) > 0.00000001) {
		if (isCheck(Ap, Aq, Bp, Bq)) {//left 의 거리가 mid보다 더 멀다면 true.
			Al = Ap; Bl = Bp;
		}
		else {
			Ar = Aq; Br = Bq;
		}
		Ap.x = (2 * Al.x + Ar.x) / 3.; Ap.y = (2 * Al.y + Ar.y) / 3.;
		Aq.x = (Al.x + 2 * Ar.x) / 3.; Aq.y = (Al.y + 2 * Ar.y) / 3.;
		Bp.x = (2 * Bl.x + Br.x) / 3.; Bp.y = (2 * Bl.y + Br.y) / 3.;
		Bq.x = (Bl.x + 2 * Br.x) / 3.; Bq.y = (Bl.y + 2 * Br.y) / 3.;
	}
	double rsult = sqrt(pow2(Ap.x - Bp.x) + pow2(Ap.y - Bp.y));
	printf("%.10lf", rsult);

	return 0;
}