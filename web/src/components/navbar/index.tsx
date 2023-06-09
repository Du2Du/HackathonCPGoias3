"use client";

import Image from "next/image";
import { usePathname } from "next/navigation";
import { BiHomeAlt } from "react-icons/bi";
import { BsPeople } from "react-icons/bs";
import { FiLogOut } from "react-icons/fi";
import { GoGear } from "react-icons/go";
import styles from "./NavBar.module.scss";
import Link from "next/link";

export const NavBar = () => {
  const pathname = usePathname();
  const setClassForOptions = (pathParam: string) => {
    const className = styles.optionContainer + " ";
    return className + (pathParam === pathname ? styles.active : "");
  };

  return (
    <nav className={styles.navbar + " flex items-center gap-3 justify-between"}>
      <div
        style={{ width: "20%" }}
        className={styles.optionContainer + " rounded-full"}
      >
        <Image width={50} height={50} />
      </div>
      <Link href={"/"} className={setClassForOptions("/dashboard")}>
        <BiHomeAlt className={styles.icon} size={30} />
        <span className={styles.text}>Inicio</span>
      </Link>
      <Link href={"/alunos"} className={setClassForOptions("/alunos")}>
        <BsPeople className={styles.icon} size={30} />
        <span className={styles.text}>Alunos</span>
      </Link>
      <Link href={"/config"} className={setClassForOptions("/config")}>
        <GoGear className={styles.icon} size={30} />
        <span className={styles.text}>Configurações</span>
      </Link>
      <Link href={"/sair"} className={setClassForOptions("/sair")}>
        <FiLogOut className={styles.icon} size={30} />
        <span className={styles.text}>Sair</span>
      </Link>
    </nav>
  );
};
