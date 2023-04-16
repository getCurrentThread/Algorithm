import decimal

a, b = input().split()

decimal.getcontext().prec = 1101
print("{0:f}".format(decimal.Decimal(a) ** int(b)))