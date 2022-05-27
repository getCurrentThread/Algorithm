answers = []
for i in range(1, int(input()) + 1):
    a, b, c, d = map(int, input().split())
    v = min(b, d) - max(a, c)
    if v <= 0:
        answers.append("#%d 0" % (i))
    else:
        answers.append("#%d %d" % (i, v))
for ans in answers:
    print(ans)
