import React, { useEffect, useState } from "react";
import axios from "axios";

const JobList = () => {
  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/jobs",
    { headers: { Authorization: `Bearer ${token}` } }
).then((res) => {
      setJobs(res.data);
    });
  }, []);

  return (
    <div>
      <h1>Job Applications</h1>
      <ul>
        {jobs.map((job) => (
          <li key={job.id}>{job.company} - {job.position} ({job.status})</li>
        ))}
      </ul>
    </div>
  );
};

export default JobList;