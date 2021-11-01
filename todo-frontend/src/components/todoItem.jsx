import React, { useEffect, useState } from 'react'

const TodoItem = (props) => {
  const { emitDeleteTodoItem } = props
  //getter setter
  const [todoItem, setTodoItem] = useState(props.data)

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
  }, [todoItem, isDirty])

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
        ❌
      </span>
    </div>
  )
}

export default TodoItem
