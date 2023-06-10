"use client";

import styles from "./ParamsPageRender.module.scss";

export const ParamsPageRender: React.FC = () => {
  return (
    <div className="p-5">
      <div>
        <label
          htmlFor="avalityQuantity"
          className="block mb-2 text-sm font-medium text-gray-900 "
        >
          Quantidade de Avaliação de Aluno por chamada
        </label>
        <input
          type="avalityQuantity"
          name="avalityQuantity"
          id="avalityQuantity"
          value={1}
          className={
            styles.inputBox +
            " bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
          }
        />
      </div>
      <button className={styles.buttonBox}>Salvar</button>
    </div>
  );
};
