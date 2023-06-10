"use client";

import { NavBar } from "@/components/navbar";
import { ConfigOptions } from "@/components/config";
import { useState } from "react";
import { ConfigScreenRender } from "./components/configScreenRender";
import styles from "./Config.module.scss";

export default function Configuration() {
  const [activeTab, setActiveTab] = useState("");

  return (
    <main className={styles.configMain}>
      <NavBar />
      <div className={styles.options + " flex items-start"}>
        <ConfigOptions activeTab={activeTab} setActiveTab={setActiveTab} />
        <ConfigScreenRender activeTab={activeTab} />
      </div>
    </main>
  );
}
