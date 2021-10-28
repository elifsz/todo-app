import logo from './logo.svg'
import './App.css'
import React, { useEffect, useState } from 'react'
import { Fragment } from 'react'
import TodoItem from './components/todoItem'

function App() {
  const [todoItems, setTodoItems] = useState(null)
  //web hook
  useEffect(() => {
    //do something on load
    console.log('hey i have load')
    //databaseden veri almak
    if (!todoItems) {
      fetch('http://localhost:8080/api/todoItems')
        .then((response) => response.json())
        .then((data) => {
          console.log('Todo items list:', data)
          setTodoItems(data)
        })
    }
  }, [todoItems])

  function addNewTodoItem() {
    //locahost dışı durumlarda nasıl yapılıyor
    fetch('http://localhost:8080/api/todoItems', {
      headers: {
        'content-type': 'application/json',
      },
      method: 'POST',
    })
      .then((response) => response.json())
      .then((aTodoItem) => {
        //sync create
        //this.setState([...todoItems, aTodoItem]) //preract
        setTodoItems([...todoItems, aTodoItem]) //hooks
      })
  }

  function handleDeleteTodoItem(item) {
    const updatedTodoItems = todoItems.filter(
      (aTodoItem) => aTodoItem.id !== item.id,
    )
    setTodoItems([...updatedTodoItems])
  }
  //todoItems!=null
  return (
    <div>
      <div>
        <button onClick={addNewTodoItem}>Add New Item</button>
      </div>
      <div>
        {todoItems
          ? todoItems.map((todoItem) => {
              return (
                <TodoItem
                  key={todoItem.id}
                  data={todoItem}
                  emitDeleteTodoItem={handleDeleteTodoItem}
                />
              )
            })
          : 'loading data'}
      </div>
    </div>
  )
}

export default App
