// ...existing code...
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";

const EditEmployee = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [employee, setEmployee] = useState({ name: "", email: "", phone: "", role: "" });
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    (async () => {
      try {
        const res = await EmployeeService.getEmployeeById(id);
        setEmployee(res.data || { name: "", email: "", phone: "", role: "" });
      } catch (err) {
        console.error(err);
        setError("Failed to load employee.");
      } finally {
        setLoading(false);
      }
    })();
  }, [id]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEmployee(prev => ({ ...prev, [name]: value }));
  };

  const handleSave = async (e) => {
    e.preventDefault();
    setError("");
    try {
      await EmployeeService.updateEmployee(employee, id);
      navigate("/");
    } catch (err) {
      console.error("Update failed", err);
      setError("Update failed. Try again.");
    }
  };

  const handleCancel = () => navigate("/");

  if (loading) return <div className="p-6 text-center">Loading...</div>;

  return (
    <div className="max-w-3xl mx-auto p-6">
      <div className="bg-gradient-to-br from-slate-800 to-slate-700 rounded-lg shadow-lg p-6">
        <h2 className="text-2xl font-semibold text-white mb-4 flex items-center gap-2">
          <span className="text-3xl">✏️</span> Edit Employee
        </h2>

        {error && (
          <div className="mb-4 text-sm text-red-200 bg-red-800/30 p-3 rounded">{error}</div>
        )}

        <form onSubmit={handleSave} className="space-y-4">
          <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
            <div>
              <label className="block text-sm text-slate-200 mb-1">Name</label>
              <input
                name="name"
                value={employee.name || ""}
                onChange={handleChange}
                required
                className="w-full px-4 py-2 rounded-lg bg-slate-600 text-white placeholder-slate-300 focus:outline-none focus:ring-2 focus:ring-green-400"
                placeholder="Full name"
              />
            </div>

            <div>
              <label className="block text-sm text-slate-200 mb-1">Email</label>
              <input
                name="email"
                type="email"
                value={employee.email || ""}
                onChange={handleChange}
                required
                className="w-full px-4 py-2 rounded-lg bg-slate-600 text-white placeholder-slate-300 focus:outline-none focus:ring-2 focus:ring-green-400"
                placeholder="name@company.com"
              />
            </div>

            <div>
              <label className="block text-sm text-slate-200 mb-1">Phone</label>
              <input
                name="phone"
                type="tel"
                value={employee.phone || ""}
                onChange={handleChange}
                className="w-full px-4 py-2 rounded-lg bg-slate-600 text-white placeholder-slate-300 focus:outline-none focus:ring-2 focus:ring-green-400"
                placeholder="9876543210"
              />
            </div>

            <div>
              <label className="block text-sm text-slate-200 mb-1">Role</label>
              <input
                name="role"
                value={employee.role || ""}
                onChange={handleChange}
                className="w-full px-4 py-2 rounded-lg bg-slate-600 text-white placeholder-slate-300 focus:outline-none focus:ring-2 focus:ring-green-400"
                placeholder="Developer / Manager"
              />
            </div>
          </div>

          <div className="flex flex-wrap gap-3 mt-4">
            <button
              type="submit"
              className="flex items-center gap-2 px-5 py-2 bg-green-500 hover:bg-green-600 text-white font-medium rounded-lg shadow"
            >
              💾 Save Changes
            </button>

            <button
              type="button"
              onClick={() => setEmployee({ name: "", email: "", phone: "", role: "" })}
              className="px-5 py-2 bg-yellow-500 hover:bg-yellow-600 text-white rounded-lg"
            >
              🔄 Reset
            </button>

            <button
              type="button"
              onClick={handleCancel}
              className="ml-auto px-5 py-2 bg-red-500 hover:bg-red-600 text-white rounded-lg"
            >
              ❌ Cancel
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default EditEmployee;
// ...existing code...