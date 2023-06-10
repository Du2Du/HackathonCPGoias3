"use client";

import { useState } from "react";
import styles from "./Register.module.scss";
import { toast } from "react-toastify";

export interface IUserRegisterProps {
  name: string;
  scholarUnity: string;
  email: string;
  password: string;
  confirmPassword: string;
}

const initialValues: IUserRegisterProps = {
  name: "",
  scholarUnity: "",
  email: "",
  password: "",
  confirmPassword: "",
};

export default function Register() {
  const [personalData, setPersonalData] =
    useState<IUserRegisterProps>(initialValues);

  const onChangeInputValue = (key: string) => (ev: any) => {
    const value = ev.target.value;
    setPersonalData({ ...personalData, [key]: value });
  };

  const validateFields = (ev: any) => {
    ev.preventDefault();
    const { confirmPassword, password } = personalData;
    console.log(password !== confirmPassword);

    if (password !== confirmPassword)
      return toast.error("As senhas não são iguais");
  };

  return (
    <main className={styles.login}>
      <div className={styles.loginContainer}>
        <h1>Cadastrar Usuário</h1>
        <form onSubmit={validateFields} className="w-100">
          <div className="mb-6">
            <div>
              <label
                htmlFor="first_name"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Nome Completo
              </label>
              <input
                type="text"
                value={personalData.name}
                id="first_name"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder="Escreva aqui"
                onChange={onChangeInputValue("name")}
                required
              />
            </div>
          </div>
          <div className="mb-6">
            <label
              htmlFor="company"
              className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >
              Unidade Escolar
            </label>
            <input
              type="text"
              id="company"
              value={personalData.scholarUnity}
              className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              placeholder="Escreva aqui"
              onChange={onChangeInputValue("scholarUnity")}
              required
            />
          </div>
          <div className="mb-6">
            <label
              htmlFor="email"
              className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >
              Email
            </label>
            <input
              type="email"
              id="email"
              value={personalData.email}
              className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              placeholder="Escreva aqui"
              onChange={onChangeInputValue("email")}
              required
            />
          </div>
          <div className="mb-6">
            <label
              htmlFor="password"
              className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >
              Senha
            </label>
            <input
              type="password"
              id="password"
              value={personalData.password}
              className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              placeholder="•••••••••"
              onChange={onChangeInputValue("password")}
              required
            />
          </div>
          <div className="mb-6">
            <label
              htmlFor="confirm_password"
              className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >
              Confirmar Senha
            </label>
            <input
              type="password"
              value={personalData.confirmPassword}
              id="confirm_password"
              className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              placeholder="•••••••••"
              onChange={onChangeInputValue("confirmPassword")}
              required
            />
          </div>
          <button
            type="submit"
            className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
          >
            Cadastrar
          </button>
        </form>
      </div>
    </main>
  );
}
