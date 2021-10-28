import React, { useEffect, useState } from 'react'

const TodoItem = (props) => {
  const { emitDeleteTodoItem } = props
  //getter setter
  const [todoItem, setTodoItem] = useState(props.data)

  /*function updateIsDone() {
      setTodoItem()
      //setTodoItem({'id':id, 'isDone':isDone, 'task':task})
    //todoItem.isDone = !todoItem.isDone
  }*/

  //isupdate or is modified
  const [isDirty, setDirty] = useState(false)
  useEffect(() => {
    if (isDirty) {
      fetch(`http://localhost:8080/api/todoItems/${todoItem.id}`, {
        method: 'PUT', //update
        headers: {
          'content-type': 'application/json',
        },
        body: JSON.stringify(todoItem),
      })
        .then((response) => response.json())
        .then((data) => {
          setDirty(false)
          setTodoItem(data)
        })
    }
    //do something on load
    //console.log('hey to the item just change',todoItem)
  }, [todoItem, isDirty])

  /*function updateTask(e) {
    setDirty(true) //for fetch and use effect
    setTodoItem({ ...todoItem, task: e.target.value })
  }*/

  function deleteTodoItem() {
    fetch(`http://localhost:8080/api/todoItems/${todoItem.id}`, {
      method: 'DELETE', //update
      headers: {
        'content-type': 'application/json',
      },
    })
      .then((response) => {
        emitDeleteTodoItem(todoItem)
      })
  }

  return (
    <div>
      <input
        type="checkbox"
        checked={todoItem.isDone}
        onChange={() => {
          setDirty(true)
          setTodoItem({ ...todoItem, isDone: !todoItem.isDone })
        }}
      />
      {todoItem.isDone ? (
        <span style={{ textDecoration: 'line-through' }}>{todoItem.task}</span>
      ) : (
        <input
          type="text"
          value={todoItem.task}
          onChange={(e) => {
            setDirty(true) //for fetch and use effect
            setTodoItem({ ...todoItem, task: e.target.value })
          }}
        />
      )}
      <span
        style={{ marginLeft: '2rem', cursor: 'pointer' }}
        onClick={() => emitDeleteTodoItem(todoItem)}
      >
        🗑️
      </span>
    </div>
  )
}

export default TodoItem
