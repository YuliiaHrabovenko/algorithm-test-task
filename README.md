# Algorithmic Tasks

Implementations of three different algorithmic challenges in **Java**. 

- ✅ Bracket expression validation and counting
- ✅ Shortest path computation between cities using Dijkstra’s algorithm
- ✅ Big integer arithmetic (digit sum of factorial)

---

## Task 1: Count of Valid Parentheses Expressions

### 📝 Problem Description
Given an arithmetic expression containing numbers, operators, and parentheses, we extract **only the parentheses** and count how many **unique valid bracket substrings** exist with exactly **N opening and N closing brackets**.

A bracket substring is **valid** if:
- All opening parentheses `(` are correctly closed by a matching `)`.
- Brackets are properly nested (balanced).

### Input
- `N` – number of bracket pairs (non-negative integer)

### 📌 Example
```
N = 1 → Valid: () → Count: 1 → Invalid: )(, )), ((
N = 2 → Valid: ()(), (()) → Count: 2
```
## 2. Shortest Path Between Cities (Graph Search)

### 📝 Problem Description
You are given a list of cities and transportation costs between directly connected pairs. The goal is to find the **minimum cost paths** between specific pairs of cities.

### Input Format
- Number of test cases n 
- Number of cities NAME 
- Name of city p 
- Number of neighboring cities nr cost 
- For each neighbor: city index and transportation cost r 
- Number of paths to find NAME1 NAME2 
- Source and destination city names

### Constraints
- Up to 10 test cases
- Up to 10,000 cities
- Path cost ≤ 200,000

### 📌 Example
```
Input: 
1
4
gdansk
2
2 1
3 3
bydgoszcz
3
1 1
3 1
4 4
torun
3
1 3
2 1
4 1
warszawa
2
2 4
3 1
2
gdansk warszawa
bydgoszcz warszawa

Output: 3 2
```
## 3. Sum of Digits in a Factorial

### 📝 Problem Description
Compute the **sum of the digits of the number `100!`** (i.e., 100 factorial).

### 📌 Example
```
100! = 933262154439...000000000000 Sum of digits = 648
```

