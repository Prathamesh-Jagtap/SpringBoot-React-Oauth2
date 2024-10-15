import React, { useEffect, useState } from "react";
import axios from "axios";
import './Profile.css'; 

const Profile = () => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    axios.get("http://localhost:8080/profile", { withCredentials: true })
      .then((response) => {
        setUser(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  if (!user) {
    return <div>Loading...</div>;
  }

  return (
    <div className="profile-container">
      <h1>Profile</h1>
      <img src={user.picture} alt="Profile" />
      <p>Name: {user.name}</p>
      <p>Email: {user.email}</p>
    </div>
  );
};

export default Profile;
