import { useState } from 'react'
import Game from './Components/Game';
import logo from './logo.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <h1>React Tutorial App</h1>
      <Game/>
    </div>
  )
}

export default App
