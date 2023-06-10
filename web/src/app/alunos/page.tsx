"use client";

import { NavBar } from "@/components/navbar";
import styles from "./Alunos.module.scss";
import { useQuery } from "react-query";
import { Backend } from "@/utils/backend";

export default function Alunos() {
  const { data: students, isLoading } = useQuery("students", () =>
    Backend.get("/user").then((res) => res.data)
  );
  return (
    <main className={styles.mainContainer}>
      <NavBar />
      {!isLoading &&
        (students as any[])?.map((student) => (
          <div key={student.uuid}>{student?.name}</div>
        ))}
    </main>
  );
}
