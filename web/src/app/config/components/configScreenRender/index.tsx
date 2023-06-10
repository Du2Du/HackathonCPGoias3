"use client";

import styles from "./ConfigScreenRender.module.scss";
import { ParamsPageRender } from "./components/paramsPageRender";
import { StudentsPageRender } from "./components/studentsPageRender";

export const ConfigScreenRender: React.FC<{ activeTab: string }> = ({
  activeTab,
}) => {
  if (!activeTab) return <></>;
  return (
    <div className={styles.configPageRender}>
      {activeTab === "alunos" ? <StudentsPageRender /> : <ParamsPageRender />}
    </div>
  );
};
