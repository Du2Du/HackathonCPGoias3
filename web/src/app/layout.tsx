import dotenv from "dotenv";
import "./globals.scss";
import { roboto } from "@/utils/fonts";

dotenv.config();

export const metadata = {
  title: "ACE System",
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body className={roboto.className}>{children}</body>
    </html>
  );
}
