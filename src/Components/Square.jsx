import React from "react";

function Square(props){
  return(
    <button className="square" onClick={props.onClick}>
      {props.value}
    </button>
  );
}
// THE BELOW CODE EQUIVALENT TO THE ABOVE (but is a class component instead). Note the onClick parentheses.
// class Square extends React.Component {
//   render() {
//     return (
//         <button
//           className="square"
//           onClick={() => this.props.onClick()}
//         >
//           {this.props.value}
//         </button>
//     );
//   }
// }

export default Square;
