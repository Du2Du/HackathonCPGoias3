"use client";

import { useQuery } from "react-query";
import styles from "./Avaliation.module.scss";
import { Backend } from "@/utils/backend";
import { useState } from "react";

export default function Avaliation() {
  const [avaliation, setAvaliation] = useState<any[]>([]);
  const { data: student } = useQuery("sortedStudent", () =>
    Backend.get("/user/raffle-student").then((res) => res.data)
  );

  const saveAvaliation = (ev: any) => {
    ev.preventDefault();
    console.log(avaliation);

    Backend.post("/behavioral-profile/avaliate", {
      avaliateResponses: avaliation,
      studentUUID: student?.uuid,
    });
  };

  return (
    <div className={styles.boxContainer}>
      <form
        onSubmit={saveAvaliation}
        className={styles.teste + " space-y-4 md:space-y-6"}
      >
        <div>
          <label className="block mb-2 text-md font-medium text-gray-900 dark:text-white">
            <b>Nome do Aluno:</b> {(student as any)?.name}
          </label>
        </div>
        <div>
          <label className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
            {(student as any)?.question}
          </label>
        </div>
        <div
          className={
            styles.avaliationBox + " flex items-center justify-between"
          }
        >
          <b>Avalie:</b>
          <input
            className={styles.inputAvaliation}
            type="number"
            max={10}
            value={avaliation[0]?.score}
            onChange={(e) =>
              setAvaliation((past: any) => [
                { ...past[0], score: Number(e.target.value) },
              ])
            }
            min={0}
          />
        </div>
        <div
          className={
            styles.observationBox + " flex items-center justify-between"
          }
        >
          <b>Observação:</b>
          <textarea
            cols={100}
            value={avaliation[0]?.observation}
            onChange={(e) =>
              setAvaliation((past: any) => [
                { ...past[0], observation: e.target.value },
              ])
            }
          ></textarea>
        </div>
        <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">
          Avaliar
        </button>
      </form>
    </div>
  );
}
