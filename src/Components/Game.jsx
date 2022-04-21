import React from "react";
import calculateWinner from "../Misc/calculateWinner";
import Board from "./Board";

class Game extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      history: [
        {
          squares: Array(9).fill(null),
        },
      ],
      xIsNext: true,
    };
  }
  handleClick(squaresIndex) {
    const history = this.state.history;
    const currentBoard = this.state.history[history.length - 1];
    const squares = currentBoard.squares.slice();
    // // ignore handleClick if there is a winner or the square is already filled
    if (calculateWinner(squares) != null || squares[squaresIndex]) {
      return;
    }
    squares[squaresIndex] = this.state.xIsNext ? "X" : "O";

    this.setState({
      history: history.concat([{squares}]),
      xIsNext: !this.state.xIsNext,
    });
    console.log("history",history);
  }
  render() {
    const history = this.state.history;
    const currentBoard = this.state.history[history.length - 1];
    const squares = currentBoard.squares;
    const winner = calculateWinner(squares);
    let status = `Next player is: ${this.state.xIsNext ? "X" : "O"}`;
    if (winner) status = `Winner: ${winner}`;
    return (
      <div className="game">
        <div className="game-board">
          <Board
            squares={squares}
            onClick={(squaresIndex) => this.handleClick(squaresIndex)}
          />
        </div>
        <div className="game-info">
          <div>{status}</div>
          <ol>{/* TODO */}</ol>
        </div>
      </div>
    );
  }
}

export default Game;
