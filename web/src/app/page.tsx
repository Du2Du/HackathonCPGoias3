import Link from "next/link";
import styles from "./Home.module.scss";

export default function Home() {
  return (
    <main className={styles.homeMain}>
      <nav className={styles.homeNavBar}>
        <span className={styles.title}>ACE System</span>
        <div className="flex items-center gap-3">
          <Link href={"/login"} className={"outlineButton rounded-full"}>
            Entrar
          </Link>
          <Link href={"/register"} className={"fillButton rounded-full"}>
            Cadastrar
          </Link>
        </div>
      </nav>
      <section>
        <div className={styles.pageTitle}>
          O sistema de análise de perfil comportamental
        </div>
        <Link href={"/about"} className="outlineButton rounded-full mt-3">
          Saiba mais
        </Link>
      </section>
    </main>
  );
}
