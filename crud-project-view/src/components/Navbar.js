import React from 'react'

const Navbar = () => {
  return (
    <div className="bg-slate-800 h-16 px-16 py-4 items-center flex">
        <h1 className="text-4xl font-bold text-green-500">🧑‍💼 CRUD Project</h1>
        <div className="space-x-4 ml-auto">
          <a className="hover:text-blue-400 text-white" href="/">Home</a>
          <a className="hover:text-blue-400 text-white" href="/">Profile</a>
          <a className="hover:text-blue-400 text-white" href="/">Logout</a>
        </div>
    </div>
  )
}

export default Navbar
