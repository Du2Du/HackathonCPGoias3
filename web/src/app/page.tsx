import Link from "next/link";
import styles from "./Home.module.scss";

export default function Home() {
  return (
    <main className={styles.homeMain}>
      <nav className={styles.homeNavBar}>
      <div className="flex items-center">
      <img
              className="w-8 h-8 mr-2"
              src="https://cdn.discordapp.com/attachments/801500020914257992/1116938572977680444/logo_transparente.png"
              alt="logo"
            />
        <span className={styles.title}>ACE</span>

      </div>
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
        <Link href={"/config"} className="outlineButton rounded-full mt-3">
          Saiba mais
        </Link>
      </section>
    </main>
  );
}
