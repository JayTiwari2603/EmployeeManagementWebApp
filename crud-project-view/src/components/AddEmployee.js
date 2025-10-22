import React from "react";
import { useNavigate } from "react-router-dom"
import EmployeeService from "../services/EmployeeService"

const AddEmployee = () => {

  const saveEmployee = (e) => {
    e.preventDefault();
    EmployeeService.saveEmployee(employee)
    .then((response)=>{
      console.log("Employee added successfully", response.data);
      navigate("/");
    })
    .catch((error)=>{
      console.log("Something went wrong", error);
    })

  }
  const [employee, setEmployee] = React.useState({
    id: "",
    name: "",
    email: "",
    phone: "",
    role: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEmployee({
      ...employee,
      [name]: value,
    });
  }

  const reset = (e) => {
    e.preventDefault();
    setEmployee({
      id: "",
      name: "",
      email: "",
      phone: "",
      role: "",
    });
  }

  const navigate = useNavigate();
  return (
    <div className="flex flex-col justify-center items-center">
      <div className="max-w-2xl w-full bg-slate-800 rounded-lg shadow-xl p-8 m-4">
        <h2 className="text-3xl font-bold text-center text-white mb-8">
          👤 Add New Employee
        </h2>
        
        <div className="space-y-4">
          <input
            type="text"
            name="name"
            value={employee.name}
            onChange={(e)=> handleChange(e)}
            className="w-full px-4 py-2 rounded-lg focus:outline-none focus:ring-2 focus:ring-green-500 bg-slate-700 text-white"
            placeholder="Enter Name"
          />
          <input
            type="email"
            name="email"
            value={employee.email}
            onChange={(e)=> handleChange(e)}
            className="w-full px-4 py-2 rounded-lg focus:outline-none focus:ring-2 focus:ring-green-500 bg-slate-700 text-white"
            placeholder="Enter Email"
          />
          <input
            type="number"
            name="phone"
            value={employee.phone}
            onChange={(e)=> handleChange(e)}
            className="w-full px-4 py-2 rounded-lg focus:outline-none focus:ring-2 focus:ring-green-500 bg-slate-700 text-white"
            placeholder="Enter Phone"
          />
          <input
            type="text"
            name="role"
            value={employee.role}
            onChange={(e)=> handleChange(e)}
            className="w-full px-4 py-2 rounded-lg focus:outline-none focus:ring-2 focus:ring-green-500 bg-slate-700 text-white"
            placeholder="Enter Role"
          />
        </div>

        <div className="flex justify-center space-x-4 mt-8">
          <button 
            type="button"
            onClick={saveEmployee}
            className="px-6 py-2 bg-green-500 text-white rounded-lg hover:bg-green-600 focus:outline-none focus:ring-2 focus:ring-green-500 transition-colors">
            💾 Save
          </button>
          <button  
           type="button"
           onClick={reset}
           className="px-6 py-2 bg-yellow-500 text-white rounded-lg hover:bg-yellow-600 focus:outline-none focus:ring-2 focus:ring-yellow-500 transition-colors">
            🔄 Clear
          </button>
          <button 
           type="button"
           onClick={()=> navigate("/")}
           className="px-6 py-2 bg-red-500 text-white rounded-lg hover:bg-red-600 focus:outline-none focus:ring-2 focus:ring-red-500 transition-colors">
            ❌ Cancel
          </button>
        </div>
      </div>
    </div>
  );
};

export default AddEmployee;