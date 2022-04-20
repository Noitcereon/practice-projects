import React from "react";
import Square from "./Square";

class Board extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      squares: Array(9).fill(null),
      xIsNext: true,
    };
  }
  handleClick(squaresIndex) {
    const squares = this.state.squares.slice(); // create a copy of the array with slice (to avoid mutating state)
    // ignore handleClick if there is a winner or the square is already filled
    if(this.calculateWinner(squares) || squares[squaresIndex]){
      return; 
    }
    squares[squaresIndex] = this.state.xIsNext ? "X" : "O";

    this.setState({
      squares: squares,
      xIsNext: !this.state.xIsNext,
    });
  }
  renderSquare(squaresIndex) {
    return (
      <Square
        value={this.state.squares[squaresIndex]}
        onClick={() => this.handleClick(squaresIndex)}
      ></Square>
    );
  }
  

  render() {
    const winner = this.calculateWinner(this.state.squares);
    let status = `Next player is: ${this.state.xIsNext ? "X" : "O"}`;
    if(winner) status = `Winner: ${winner}`;

    return (
      <div>
        <div className="status">{status}</div>
        <div className="board-row">
          {this.renderSquare(0)}
          {this.renderSquare(1)}
          {this.renderSquare(2)}
        </div>
        <div className="board-row">
          {this.renderSquare(3)}
          {this.renderSquare(4)}
          {this.renderSquare(5)}
        </div>
        <div className="board-row">
          {this.renderSquare(6)}
          {this.renderSquare(7)}
          {this.renderSquare(8)}
        </div>
      </div>
    );
  }

  calculateWinner(squares) {
    const lines = [
      [0, 1, 2],
      [3, 4, 5],
      [6, 7, 8],
      [0, 3, 6],
      [1, 4, 7],
      [2, 5, 8],
      [0, 4, 8],
      [2, 4, 6],
    ];
    for (let i = 0; i < lines.length; i++) {
      const [a, b, c] = lines[i];
      if (
        squares[a] &&
        squares[a] === squares[b] &&
        squares[a] === squares[c]
      ) {
        return squares[a]; // return winner
      }
    }
    return null; // no one has won
  }
}

export default Board;
