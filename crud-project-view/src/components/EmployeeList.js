import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import EmployeeService from '../services/EmployeeService'

const EmployeeList = () => {
  const [loading, setLoading] = useState(true);
  const [employees, setEmployees] = useState([]); 
  const navigate = useNavigate();

  useEffect(() => {
    fetchEmployee();
  }, []);

   const deleteEmployee = async (id) => {
    try {
      await EmployeeService.deleteEmployeeById(id);
      // Refresh the list after deletion
      fetchEmployee();
    } catch (error) {
      console.error("Error deleting employee:", error);
    }
  };

  const handleEdit = (id) => {
    navigate(`/editEmployee/${id}`);
  };


  const fetchEmployee = async () => {
    setLoading(true);
    try {
      const response = await EmployeeService.getEmployees();
      setEmployees(response.data || []); // Ensure we always have an array
    } catch (error) {
      console.error("Error fetching employees:", error);
      setEmployees([]); // Set empty array on error
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return <div className="text-center p-4">Loading...</div>;
  }

  return (
    <div className="container mx-auto my-8 px-4">
      <div className="flex justify-between items-center mb-8">
        <h2 className="text-3xl font-bold text-slate-800">👥 Employee Directory</h2>
        <button 
          onClick={() => navigate("/addEmployee")}
          className="bg-green-600 hover:bg-green-700 text-white font-semibold py-2 px-6 rounded-lg transition duration-300 ease-in-out flex items-center"
        >
          <span className="mr-2">➕</span>
          Add Employee
        </button>
      </div>

      <div className="overflow-x-auto bg-white rounded-lg shadow-lg">
        {employees.length === 0 ? (
          <p className="text-center p-4">No employees found</p>
        ) : (
          <table className="min-w-full table-auto">
            <thead className="bg-slate-800 text-white">
              <tr>
                <th className="px-6 py-4 text-left text-sm uppercase tracking-wider font-semibold">📧 Email</th>
                <th className="px-6 py-4 text-left text-sm uppercase tracking-wider font-semibold">👤 Name</th>
                <th className="px-6 py-4 text-left text-sm uppercase tracking-wider font-semibold">📱 Phone</th>
                <th className="px-6 py-4 text-left text-sm uppercase tracking-wider font-semibold">💼 Role</th>
                <th className="px-6 py-4 text-center text-sm uppercase tracking-wider font-semibold">⚡ Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-gray-200">
              {employees.map((employee) => employee && (
                <tr key={employee.id || Math.random()} className="hover:bg-slate-50 transition-colors duration-200">
                  <td className="px-6 py-4 text-slate-600">{employee?.email}</td>
                  <td className="px-6 py-4 text-slate-600 font-medium">{employee?.name}</td>
                  <td className="px-6 py-4 text-slate-600">{employee?.phone}</td>
                  <td className="px-6 py-4">
                    <span className="px-3 py-1 text-xs font-semibold text-green-600 bg-green-100 rounded-full">
                      {employee?.role}
                    </span>
                  </td>
                  <td className="px-6 py-4 text-center">
                    <button onClick={() => handleEdit(employee.id)}
                    className="text-blue-600 hover:text-blue-800 mx-2 transition-colors duration-200">
                      ✏️ Edit
                    </button>
                    <button type="button"
                     onClick={() => deleteEmployee(employee.id)}
                     className="text-red-600 hover:text-red-800 mx-2 transition-colors duration-200">
                      🗑️ Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  )
}

export default EmployeeList