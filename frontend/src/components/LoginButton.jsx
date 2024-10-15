import React from "react";
import { FcGoogle } from 'react-icons/fc';
import './LoginButton.css'

const LoginButton = () => {
  const handleLogin = () => {
    window.location.href = "http://localhost:8080/oauth2/authorization/google";
  };

  return (
    <>
      <div className="login-container">
      <button className="login-btn" onClick={handleLogin}>
        <FcGoogle size={24} />{' '}Login with Google
      </button>
    </div>
    </>
  )
};

export default LoginButton;
