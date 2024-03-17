import sys

orign = int(sys.stdin.readline().rstrip())
print((2 ** orign) - 1)

def move_disks(n, frm, aux, to):
    if n == 1:
        print(frm, to)
        return
    move_disks(n-1, frm, to, aux)
    print(frm, to)
    move_disks(n-1, aux, frm, to)

move_disks(orign, 1, 2, 3)
