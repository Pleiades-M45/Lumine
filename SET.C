#include <stdio.h>
#include <conio.h>

int u[10], a[10], b[10],c[10],d[10], p,q,n;

void bitdis(int x[]) {
    int i;
    printf("{");
    for (i = 0; i < n - 1; i++)
	printf("%d, ", x[i]);
    printf("%d}", x[n - 1]);
}

void display(int x[],int len) {
    int i;
    printf("{");
    for (i = 0; i < len-1; i++)
	printf("%d, ", x[i]);
    printf("%d}", x[len-1]);
}

int pos(int x) {
    int i, f = -1;
    for (i = 0; i < n; i++) {
        if (u[i] == x)
            f = i;
    }
    return f;
}

void setunion() {
    int i;
    printf("\nUnion : ");
    for (i = 0; i < n; i++) {
        if ((a[i] | b[i]) == 1) 
	    printf("%d ", u[i]);
    }
}

void intersect() {
    int i;
    printf("\nIntersection : ");
    for (i = 0; i < n; i++) {
        if ((a[i] & b[i]) == 1) 
	    printf("%d ", u[i]);
    }
}

void setdiff() {
    int i;
    printf("\nDifference : ");
    for (i = 0; i < n; i++) {
        if ((a[i] & !b[i]) == 1) 
	    printf("%d ", u[i]);
    }
}

int main() {
    int i, x;
    clrscr();

    printf("Enter size of universal set: ");
    scanf("%d", &n);
    printf("Enter elements of the universal set: ");
    for (i = 0; i < n; i++) {
        scanf("%d", &u[i]);
        a[i] = b[i] = 0; 
    }

    printf("\nEnter size of set 1: ");
    scanf("%d", &p);
    printf("Enter elements of set 1: ");
    for (i = 0; i < p; i++) {
	scanf("%d", &x);
	c[i]=x;
        if (pos(x) != -1) 
            a[pos(x)] = 1;
    }

    printf("\nEnter size of set 2: ");
    scanf("%d", &q);
    printf("Enter elements of set 2: ");
    for (i = 0; i < q; i++) {
	scanf("%d", &x);
	d[i]=x;
        if (pos(x) != -1)  
            b[pos(x)] = 1;
    }

    printf("\nSet 1: ");
    display(c,p);
    printf("\nSet 2: ");
    display(d,q);

    printf("\n");

    printf("\nUniversal set: ");
    bitdis(u);
    printf("\nSet 1 bit string: ");
    bitdis(a);
    printf("\nSet 2 bit string: ");
    bitdis(b);

    setunion();
    intersect();
    setdiff();

    getch();
    return 0;
}
