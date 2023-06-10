import dotenv from "dotenv";
import "./globals.scss";
import { roboto } from "@/utils/fonts";
import { Providers } from "@/utils/providers";

dotenv.config();

export const metadata = {
  title: "ACE",
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body className={roboto.className}>
        <Providers>{children}</Providers>
      </body>
    </html>
  );
}
