import './App.css';
import Navbar from './components/Navbar';
import EmployeeList from './components/EmployeeList';
import AddEmployee from './components/AddEmployee';
import EditEmployee from './components/EditEmployee';
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    // line 6 is called fragment in react
    <>
      <BrowserRouter>
      <Navbar/>

      <Routes>
        <Route index element={<EmployeeList/>}/> 
        <Route path="/AddEmployee" element={<AddEmployee/>}></Route>
        <Route path="/" element={<EmployeeList/>}/>
        <Route path="/editEmployee/:id" element={<EditEmployee/>} />  {/* new route */}

        {/* <Route path="/AddEmployee" element={<AddEmployee/>}/> */}
      </Routes>
      </BrowserRouter>
      

      
    </>
    // this is called fragment in react
  );
}

export default App;