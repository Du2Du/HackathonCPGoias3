"use client";

import { NavBar } from "@/components/navbar";
import styles from "./Alunos.module.scss";
import { useQuery } from "react-query";
import { Backend } from "@/utils/backend";
import { IStudentProps, StudentItem } from "./components/studentItem";

export default function Alunos() {
  const { data: students, isLoading } = useQuery<IStudentProps[]>(
    "students",
    () => Backend.get("/user").then((res) => res.data)
  );
  return (
    <main className={styles.mainContainer}>
      <NavBar />
      <div className={styles.studentsList}>
        {!isLoading &&
          students?.map((student) => (
            <StudentItem student={student} key={student.uuid} />
          ))}
      </div>
    </main>
  );
}
