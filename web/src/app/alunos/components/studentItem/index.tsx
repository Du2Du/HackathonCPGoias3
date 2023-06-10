"use client";

import Link from "next/link";
import styles from "./StudentItem.module.scss";
import { AiOutlineEye } from "react-icons/ai";
import { useRouter } from "next/router";

export interface IStudentProps {
  name: string;
  email: string;
  uuid: string;
  roleName: string;
  age?: number;
}

export const StudentItem: React.FC<{ student: IStudentProps }> = ({
  student,
}) => {
  const redirectToBehaviorPage = () => {
    location.assign(`/alunos?uuid=${student.uuid}`);
  };
  return (
    <div className={styles.studentBox}>
      <div>
        <div>
          <b>Nome: </b>
          <span>{student.name} </span>
        </div>
        <div>
          <b>Email: </b>
          <span>{student.email} </span>
        </div>
        <div>
          <b>Idade: </b>
          <span>{student.age ?? "Não disponivel"} </span>
        </div>
      </div>
      <AiOutlineEye size={30} onClick={redirectToBehaviorPage} />
    </div>
  );
};
