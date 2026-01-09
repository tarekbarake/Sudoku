# Sudoku Solver (Java) — Backtracking + Constraint Checking

A simple **Sudoku solver in Java** that solves a standard **9x9** Sudoku puzzle using a **recursive backtracking** algorithm.  
Empty cells are represented with `0`. The solver tries values `1..9` and uses row/column/3x3-box checks to ensure each placement is valid.

---

## Features
- ✅ Solves **9x9 Sudoku** boards using **backtracking**
- ✅ Validates moves with:
  - Row constraint (`isAllowedRow`)
  - Column constraint (`isAllowedCol`)
  - 3×3 box constraint (`isAllowedInOneBox`)
- ✅ Prints whether the board was solvable (`true/false`)
- ✅ Prints the solved board using `Arrays.deepToString()`

---

## How It Works (High Level)
1. Start from the top-left cell `(row=0, col=0)`.
2. If a cell is already filled (not `0`), move to the next cell.
3. If a cell is empty (`0`), try numbers from `1` to `9`.
4. For each number, check if placement is valid:
   - Not in the same row
   - Not in the same column
   - Not in the same 3×3 box
5. If valid, place it and continue recursively.
6. If later it leads to a dead end, reset the cell back to `0` (**backtrack**) and try the next number.
