"use client";

import styles from "@/components/config/ConfigOptions.module.scss";

export const ConfigOptions: React.FC<{
  setActiveTab: (value: string) => void;
  activeTab: string;
}> = ({ setActiveTab, activeTab }) => {
  return (
    <div className={styles.configPanel}>
      <button
        className={
          styles.configButton +
          " " +
          (activeTab == "alunos" ? styles.active : "")
        }
        onClick={() => setActiveTab("alunos")}
      >
        Vincular alunos
      </button>
      <button
        className={
          styles.configButton +
          " " +
          (activeTab == "params" ? styles.active : "")
        }
        onClick={() => setActiveTab("params")}
      >
        Parametros do sistema
      </button>
    </div>
  );
};
