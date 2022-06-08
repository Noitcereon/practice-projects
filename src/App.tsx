import { useState } from 'react'
import logo from './logo.svg'
import './App.css'
import Home from './Components/Home'
import Login from './Components/Login'

function App() {

  return (
    <div id="app">
      <header>

        <Login></Login>
      </header>
      <main>
        <Home/>
      </main>
      <footer>

      </footer>
    </div>
  )
}

export default App
