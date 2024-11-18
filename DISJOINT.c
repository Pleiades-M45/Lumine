#include <stdio.h>
#define MAX 10

int parent[MAX];
int rank[MAX];

void makeSet(int n) {
    for (int i = 0; i < n; i++) {
        parent[i] = i; 
        rank[i] = 0;     
    }
}

int find(int x) {
    if (parent[x] != x) {
        parent[x] = find(parent[x]);
    }
    return parent[x];
}

void unionSets(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);

    if (rootX != rootY) {
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;  
        }
    }
}

void display(int n) {
    printf("Element\tParent\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t%d\n", i, parent[i]);
    }
}

int main() {
    int n = 10; 
    makeSet(n);

    unionSets(0, 2);
    unionSets(4, 2);
    unionSets(3, 1);
    unionSets(1, 5);

    printf("Disjoint Set after unions:\n");
    display(n);

    // Check the representatives (roots) of some sets
    printf("\nRepresentative of set containing 0: %d\n", find(0));
    printf("Representative of set containing 1: %d\n", find(1));
    printf("Representative of set containing 4: %d\n", find(4));
    printf("Representative of set containing 5: %d\n", find(5));

    if (find(0) == find(2)) {
        printf("0 and 2 are in the same set.\n");
    } else {
        printf("0 and 2 are in different sets.\n");
    }

    if (find(1) == find(5)) {
        printf("1 and 5 are in the same set.\n");
    } else {
        printf("1 and 5 are in different sets.\n");
    }

    return 0;
}



// #include <stdio.h>
// #define MAX 10

// int parent[MAX];
// int rank[MAX];

// // Function to initialize the disjoint set
// void makeSet(int n) {
//     for (int i = 0; i < n; i++) {
//         parent[i] = i;  // Initially, each element is its own parent
//         rank[i] = 0;     // Initially, the rank of each tree is 0
//     }
// }

// // Function to find the representative (root) of the set containing 'x'
// // It uses path compression to flatten the tree
// int find(int x) {
//     if (parent[x] != x) {
//         parent[x] = find(parent[x]);  // Path compression
//     }
//     return parent[x];  // Return the root of the set
// }

// // Function to perform the union of two sets containing 'x' and 'y'
// // It uses union by rank to keep the tree balanced
// void unionSets(int x, int y) {
//     int rootX = find(x);  // Find the root of set containing 'x'
//     int rootY = find(y);  // Find the root of set containing 'y'

//     if (rootX != rootY) {
//         // Union by rank: attach the smaller tree under the larger tree
//         if (rank[rootX] < rank[rootY]) {
//             parent[rootX] = rootY;
//         } else if (rank[rootX] > rank[rootY]) {
//             parent[rootY] = rootX;
//         } else {
//             parent[rootY] = rootX;  // Arbitrarily choose rootX as the new root
//             rank[rootX]++;  // Increment the rank of the new root
//         }
//     }
// }

// // Function to display the parent of each element and their ranks
// void display(int n) {
//     printf("Element\tParent\tRank\n");
//     for (int i = 0; i < n; i++) {
//         printf("%d\t%d\t%d\n", i, parent[i], rank[i]);
//     }
// }

// int main() {
//     int n = 10;  // Number of elements in the disjoint set

//     makeSet(n);  // Initialize the disjoint set

//     // Perform some union operations
//     unionSets(0, 2);
//     unionSets(4, 2);
//     unionSets(3, 1);
//     unionSets(1, 5);

//     // Display the current sets (parents)
//     printf("Disjoint Set after unions:\n");
//     display(n);

//     // Check the representatives (roots) of some sets
//     printf("\nRepresentative of set containing 0: %d\n", find(0));
//     printf("Representative of set containing 1: %d\n", find(1));
//     printf("Representative of set containing 4: %d\n", find(4));
//     printf("Representative of set containing 5: %d\n", find(5));

//     // Check if two elements belong to the same set
//     if (find(0) == find(2)) {
//         printf("0 and 2 are in the same set.\n");
//     } else {
//         printf("0 and 2 are in different sets.\n");
//     }

//     if (find(1) == find(5)) {
//         printf("1 and 5 are in the same set.\n");
//     } else {
//         printf("1 and 5 are in different sets.\n");
//     }

//     return 0;
// }
