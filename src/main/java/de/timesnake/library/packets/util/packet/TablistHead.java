/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.packets.util.packet;

import de.timesnake.library.entities.entity.PlayerBuilder;
import net.minecraft.world.entity.player.Player;

public enum TablistHead {
  BLANK(
      "eyJ0aW1lc3RhbXAiOjE0MTEyNjg3OTI3NjUsInByb2ZpbGVJZCI6IjNmYmVjN2RkMGE1ZjQwYmY5ZDExODg1YTU0NT"
          +
          "A3MTEyIiwicHJvZmlsZU5hbWUiOiJsYXN0X3VzZXJuYW1lIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHR"
          +
          "wOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzg0N2I1Mjc5OTg0NjUxNTRhZDZjMjM4YTFlM2MyZGQz"
          +
          "ZTMyOTY1MzUyZTNhNjRmMzZlMTZhOTQwNWFiOCJ9fX0=", "u8sG8tlbmiekrfAdQjy4nXIcCfNdnUZz" +
      "XSx9BE1X5K27NiUvE1dDNIeBBSPdZzQG1kHGijuokuHPdNi/KXHZkQM7OJ4aCu5JiUoOY28uz3wZhW4D+KG3dH4ei5ww2Kwvj"
      + "cqVL7LFKfr/ONU5Hvi7MIIty1eKpoGDYpWj3WjnbN4ye5Zo88I2ZEkP1wBw2eDDN4P3YEDYTumQndcbXFPuRRTntoGdZq3N5E"
      + "BKfDZxlw4L3pgkcSLU5rWkd5UH4ZUOHAP/VaJ04mpFLsFXzzdU4xNZ5fthCwxwVBNLtHRWO26k/qcVBzvEXtKGFJmxfLGCzXS"
      + "cET/OjUBak/JEkkRG2m+kpmBMgFRNtjyZgQ1w08U6HHnLTiAiio3JswPlW5v56pGWRHQT5XWSkfnrXDalxtSmPnB5LmacpIIm"
      + "KgL8V9wLnWvBzI7SHjlyQbbgd+kUOkLlu7+717ySDEJwsFJekfuR6N/rpcYgNZYrxDwe4w57uDPlwNL6cJPfNUHV7WEbIU1pM"
      + "gxsxaXe8WSvV87qLsR7H06xocl2C0JFfe2jZR4Zh3k9xzEnfCeFKBgGb4lrOWBu1eDWYgtKV67M2Y+B3W5pjuAjwAxn0waODt"
      + "En/3jKPbc/sxbPvljUCw65X+ok0UUN1eOwXV5l2EGzn05t3Yhwq19/GxARg63ISGE8CKw="),

  //dots
  DOT_BLACK(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTc0NTY5MDEsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMDY0OGJl"
          +
          "MGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzL"
          + "m1pbmVjcmFmdC5uZXQvdGV4dHVyZS85ZjcxNTBkM2U1ZGY3ZjIxNzEyODlmM2M1ODYzYzkyYzJjODkwOGMzMmFkZGM4NmVhN2Y2MW"
          + "VkODQ3YjY5ZCJ9fX0=",
      "v4HSztoVOn0TMBHyDymPBItvOpWs8z6twVamfdrE4yhr8HZoBYWzl+qxfWu+8+DNyBSCp"
          + "N6nr/UQpFErdys9Kk6urIURx8mEeWDXcYOhXrFs7oNpXiD7UvYm4nd+vNr0xbpfQmSXBGIZ+eOei4ThbKdkSIB79mlq0ugbwxCsK"
          + "2I8kUlUU6+KnsunPr80adcPu9RryAW00Bmta+eP65nIKwUWNKeLb5iHaPq+N/IZ5aKHmLFiSXiWniDB5UAYybkBZFuvosSr4TBpn"
          + "1pTbEF3PtKpnPM/8mpt+97W1JcCAv0mdFZUr0hT9eMAe3U0r37J4w/RmLd0sCD7zOBX0pIPPIMrXOQ4DfuDbKSJPXyXiLQQrWCHY"
          + "nOO8+8kiQcoQ427trsb2y+jMwYel2GEU6gS5zOdkkVm8Je6tNxgA8vRGqA8ABW8SVQz7y5spk2CGiTQQbV3EeJwKcZHXAAplkoSB"
          + "0p8fRE1fEY0+REoETg5TbguZnONm1+PdW/LdLifL2tGClSz6Nb4D513zZuJaFc/dQ7yagJR0cFkuWVuI59ZnoKqiEW+tMsrhn7Qw"
          + "CwGN6eASHd9seNvnTXsGOyZ0iOWFCay7JWOGSMr8iGiYCd92kn4r+UbCJ+OtokHzxFIoEHr2hRnN6thye27/tpP9Is7cmmmrDAKv"
          + "ecGtYfsrCVmTIw="),
  DOT_DARK_BLUE(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTc1MzgyNDIsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMDY0OGJlM"
          + "GI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzL"
          + "m1pbmVjcmFmdC5uZXQvdGV4dHVyZS8zM2I2NWQ3OGMwYjI5N2RhMzgxYWJlN2JhZmM1ZmE2YzFhZWVhZTY5NDcxZDlhN2JhYWQxZ"
          + "DQ5Y2FmZjVkYjkifX19",
      "mKqD4+2/uXiIjNmtQDcaGoxghxN3d+YFX5VgVHO1whwWSdEzRtNj3tw5CJOyBZVzQh6"
          + "GfYqqi38ylfCiBq6t3JAYfaf4BxsDSKyq4yRfNb2JnYQoXGrhIhwMqEEyieXoJUshnBXpneASDf0a+BE5hN29l2vqQGs9VPKggqb"
          + "t2zpZHyUi6tQMlwOiL+jDKh1bcSr4Wl1Ad8JC/BhUXytOR5u0FWm4vOEsqq8Td7S4Jm+XzgwxogtrpeVhRMFwYL7snjehYF3qh1W"
          + "9p8PNmJGtZ9AApUctc/qEVnWeCOnDAaKgqozj4ruc4Xk2KMXxj0GmDS6b65C3m71MG+cW/0sS/Rx8vmif9SJum+E8C0X8inNr1nu"
          + "i+3ulmwqC3x0MeVsp81cr+LJIA2dcryKVWV3W6hkYuc3OBUjxrN6NOP495fEsPTFx33eop+pajS8g8Re4drNYHUSy7suzDOq+Yv1X"
          + "M3hOASN/msCU79/tj1G7HIQ2+RHz2eFZlUWC3IEX+5BM5cf7uK1hhkkbejUkmQSblFGeuTnUdV7Yr6kmn0kXQbHAOIrRvw8d91x1"
          + "lHoX7yjh+HbG4+RymOcm09MJAfdaut7Q8fINHM7rsiHOT6P0Tj7u1UXUUT9w9YXkVgEPCpjSjsjfkGblq/bzDzg8d/es3aZd00Wm"
          + "qFGjlNMx/EKVf/A="),
  DOT_GREEN(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTc2MzUyNTgsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMDY0OGJl"
          +
          "MGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmV"
          + "zLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8xMDU3ZTUxYWE2MmFmMjQ4NjdjNjc1Mzc4NmYyMzRkOWJlYjI1NDEyMjM5MTc4YTcxOD"
          + "ZkODE4NjkxNmU2YyJ9fX0=",
      "P6gT4sSTDPKon9h+Qp/JEK1minlQQRi0ReIsYdYFzHiVpOejPxq4MU+0Ebmvs2"
          + "3mgX2tgqUQV8oeHK9xNCoTB4cKrLMq0U7JJ4C6ShCrQXL3Mr6MilVIDUbP4Fvj9uLU9vFCEiyHVnYwKlnIsnDxnOOBFzki5Tya"
          + "FTVt2LeNrlso6eh9ARpa5PCAevtEDDrZ51ftvoI268RrbQTfgE7coiDYAcEzgSY9Lm5I9vQxIN6VWhh/tUxHHdn8u1eDIbga/I"
          + "/EuQZ6H+V0E3THmR55ob4mKZ4e3TYWWRRlOIZPOdFcPIluVdkVZG03cQfw8RYsON/dazBnbME55NTF8U6ovyDWcwYhCEJtRtA4"
          + "yGMOocX06InRDOkmFk8FcomtJF0WFSSZRbNfxEmG1XXZx1VtKX4eYR97Y/ihOBilN+Aq5yQ2AB+JvEPb1NFiQHdu3mQ/E4tJxK"
          + "gsorFd75xbPBV7A/mPsrUV2GHvLFJzlBQGDYJCWqqIEdRV/V417j0XlpM+D7UBiIekcsDo2ajOg0v5mQqGF5d1+H16K58PgAOk"
          + "PLmKwy3lTAnpPWhSWfcrSbkon93eezlD6eMZie8YG2ucaPR9TXYXRwLxK9DrCx5ZfzQV4lgeDSsL2i8kNnYmTLZ1DnsVw8IwWi"
          + "fUFGwwapHFWO1thdy5yifjaa/AOWYTJQE="),
  DOT_DARK_AQUA(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTc3MDY0NTAsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMD" +
          "Y0OGJlMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3Rl"
          + "eHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9mODZiZmEyODRjOGM1ODk3NTFiMzQ1NDA1NTc0NGM4YmM0MGVmNjVlYTZiY2"
          + "RlYzc3NDg2YzllNDE3N2FmOSJ9fX0=",
      "LGisiuVbSaI9K2dXN9CsV8SxuXieWvCHTg1mdjUh744AYQBbINiEgEb"
          + "XiFz3cQXzzJttUAW8MPZyBnl4qxJr5QRXd4mB8bOd6nA9eimRPiCIpS8QG6V5YZWdyEvKuV+xpdWNkB8I4kpgkRFBmYsKNWeg3"
          + "xhmgeA0QP1kpadGKU4oOMb5vzUzsIVbyycjhtGcRNuGKjZaNoHVssuTUpi83xIqdCPI353rsltncBY4Idheig0cUzBXqvLX0K3"
          + "pVxVgg+jQxRPRlGdLhiMXXs6IkRj1glvcZO4MEMg4IfA/W6Vq4UiVG6RpubS53jDJDt4G4ZrtSVX07rQOowHlnY8xIgtpSAbW2"
          + "iy+uHu3mvv4lWATZE7irU3QrRg7PUSZYSIihqY+CWp8eJwhs+JxTTBMqCzfv5HvZg73WVj2003JTIIxtqTyrlBxIa+4DnPBho"
          + "CJ+N0v7wmLdZQC+PsVaRAC8nrlhgDewfglW9HHhqU8m5LVa5gDyMlkIOo6w8cW3mOCTqndGNf4GmDVCbli5Yu5SptaZXvibCp"
          + "8HcNmkJdP6yf4h/hKPEvOc1QzQOm4L5+9jJxGtpZA2+sTDXqucI2TPy5XNxd9+GaZP9J/xMiwihqeGYmNXbjCJdFSE5NX71HH0"
          + "NbIVQu5G2VIFccuKkz0iDP1vl60ZiHZdVhn3DcL1gY="),
  DOT_DARK_RED(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTY3MTU0NzcsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMDY0OG"
          +
          "JlMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1c"
          + "mVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS82YWM4ZDlmNjQ1ZDU1MDE4MzRkZGZjNGY4YjVkMzIxNmQ5NGYyMTEyOWE2OWQ4YmE0"
          + "YzJiZjE4YzE0MzEyOWQifX19",
      "D7ub7tuNpCdQckdl9tMJMoSF9XfEAhL0UA4hqMNUcm++uHJviVXbI9ePlg98+"
          + "N5aisqzVj19/Ld1DaJENFH8eKtQ+lhvzS6Rh+x/JF/QGfDGbWSbx9J9H86LvJpY28hQ/XJ1cFSmtqK5xlnXBNilFj+sAtqCJ+KR"
          + "dPzwnhgvMNqFMmy5op4qjHaQH4QN997DDF8RWt/9dMzoBDS32sr9RAwzyQzuRsa2mHyMbrrPzST78tcyBWk/dddE5zY9qdt7sD"
          + "tkar3hDOEMgrid+ChxmAlh/LulaXhpW2S0XEsUEY3uBc58iNrnIWaQedaYYaFFdXPe95BPMaMXtgHblRsOhWlvTAXv9P/CB3v0"
          + "PKlbfH+kFZyf/OgHfkZan575dAdeEl5mVdT6h7rqriau3MIj/MPUX76xMY+0cbNUGG8Dmw5s6Fw2CnkBuRJWaf9NlSynxm0S/K"
          + "8BqF/UdGCHc3BVYJ54Bhc65KyN2EONaON2OT2p41Ssvt0Z1UEdb9w+0G+pMYJ9qp/firkdsyQC0VQepymxTDvsmhrA+MC/fb4Q"
          + "L47XucJIFGzhi/qbxj+AjKSt6jhbqYUNE74Y4S8U6fsjIko5dEiQ1eVhq+TOsGAiF0M5M84Jpcyh3B/agvJLic4zIwR0AEE91O"
          + "k5ZM8hOimhQf206XvYItw3FqNGjdOsiPw="),
  DOT_PURPLE(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTc5MTAxMDMsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMDY0OG"
          +
          "JlMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1c"
          + "mVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS83NmNiYjYzYWFjMzM2OWE2NzI1ZDQyZmEyMjM4OGFhZmUzYzFiM2YyYTE1MTlkMTA3"
          + "MjE4NDMxOTgzNWNjYyJ9fX0=",
      "QUWtd7snPe+R9CWdOgAVlagJE79wO4NUGouqctu+/38p2L2b8PRyFydPURaN7"
          + "gimsBd3+XM6fd2SqS5goc/wj/YXn7FKrIAWP7Wlq1+638006wKaqtyeIXPIOEGBt5fZ/ooYvKDlVjEkyZ1MHwhUVtkmBDUGkvG0"
          + "5WKOJ0LscyCuUw93qfE9LJjowMLubIw1Aq3gSo0dmcN+KcSebHxP7ppThE14BZBrUr2h5zbu1LLYSDKgjFiO3BFkVKFTXtz8P3/"
          + "kLprQUycT+ojGf8aye2WjO9GlEkiEEj/MLb31B8ImbOZcFWpmqEGfxctKyK2UNZdVrof+Y2qKpZMMVcn6H1SWCM+H/vt7y0wxs9"
          + "j6kk+xkFTgQJUJY4Y+lBuT+id5Zm0iP3Ua/dCauhlQNezWvCnvx/ICKtGaibzpsouScj/2XMapnQQBNnurTK6v5viDvlt3vF5sd"
          + "g/pRYDtqyKF6j0prBjQJBayAmANMIefAVYKwGyHONg+JJi72JEm9srIamp1a3ijfP+gYj/1wKtu38w4t3Yfbr7PRO5ArhZbUKvx"
          + "w+nIDRPwK41SqARU/j9aWVtsud4ASigNno8KNndH9Q/RIfXXukKBNi69PRvPgG+FKhrpN+U+13Zcdzx0mtkMK+ZGb1Qp05Ko7gD"
          + "fCFawWQE8wKiFC6mIWzWVSeCMqdQ="),
  DOT_GOLD(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTc5NDUxMzEsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMDY0OGJ"
          +
          "lMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmV"
          +
          "zLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9jOGM0ZDQ0OGIxZTEzYTI1ZGUzODg0ZGIxN2Q5YjBlZDM4ZGY1ZDEyM2RlNTc3M2YzOD"
          + "IyZWJiNTNhNzYxZTMzIn19fQ==",
      "gdr3b0Zy/uOlU4VdDuAmnPGhKlg9qImK4zj0qoisJZfiVYrPNPeQCocxVvn"
          + "kAYqsuTsoe7UUo5/oW/G6Z6AKw+2aapkNbUSwxhdCb2vLmnIt8WGhxTxKcd2OEdCnAmCNgtcF8kF062yK8Enoni2eJI2oV+7Me"
          + "ktoFWV5pWBkSmhNMBuw5AraYv9S0+zJTYjX0eANTuNXV+VKnfzMCcKuyOBwqXhNMzL9vmvXTMBJAr9bYx/xH3POO5xhGRrW4Ny"
          + "uWSE9SXhV4NngSR+59kImfZmSA6d9kuK26feZrfRrAME/UV2rjbnT4WWumYzvrroZKJBcq++yBEsVluEagkWzs8UXOtOiNYtt"
          + "p4ETg19aYObXdQSLGFRzTeVCVw4cHVSX6Svbiie/Kyr+s/5fQX7/LCs7uVlclPMrabQiam/DzDRre3hbEHXTfiUCLFQLjyqOQ1"
          + "+gsPqWN2E/HMj0I9gbKL6qrgRVstvTf97UXqXxXudbOC3EthdgAM4n/lR8s6RqmqwzfdkWAyvYGW2c49tImnEtaltwhzeprUR"
          + "Ny/dEbLkU3KYfXx2nVHO7+d67WJscwHiffyxDpLwTWkclIrC7bl2SKyfib1cElDqzXNzKYeqZ595PkiHeBBRjL9CWLTlXcLMW"
          + "uJtdqvquCXt6oJ7EtalcVhKE6DHXdtBDDYDaWpA="),
  DOT_LIGHT_GRAY(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTc5NjU3ODgsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcy" +
          "MDY0OGJlMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3"
          + "RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8yYzkzZWJjNzc3YTg3OWVkZWViMTFiOTY2MWNmYTZkNzdkZjk0ZTY1NWM0"
          + "ZTI4N2Y5NmY0ZmY3OTI1Mjc2In19fQ==",
      "jL/5arN/cnJbD/DZG9HTo1ckkwZk+XXYUe6QUqbZ0QAm/wecw/mD"
          + "ZqvGwqwnngsgyg0UelxPHvRK3J3z3SdVq7Kavq2UdGkFLr1fe+34bxTnzricHXs4baYDQPOunmbdHgDs+7wwjYJbuQ4nNRE0vQ"
          + "sCmMAe2epchFEDRsiWYuBS0bWCDtQzCBJasGridmH8MIpBmicKQ8OWor9q9T/Pvxh1KEJdpFJuvEGS6xA1J3GxuRT6Iq1elATJ"
          + "NhW3P0MeHU5f/C8N42clLy9K2W8DGm0VuDQbYZmBCaxYcIo3kbkAVVZ6LGHfO8q0kxKIq9q+qXcmn5TQK3BmyjqTGY3PFYRVR9"
          + "thgA+LWk1s1Ln1jA6ousckJmQJa1eW73mRt91fvRVAMUGm5qrwScL6q2pe3BjBfB3OnilSR3x2cdwM3WkmfN8VuELykJvxHIhD"
          + "XGCxI5Xg4ghPyZvqW1NNTJmCUokp/fEt+64ZkXoqXzzV88pGZXuVC3ySgg4hdhL4he0tUOVQHttls+lQ2id6R3XaHdh4Hlk/"
          + "+vVUV2oqJ+XGb5juD/MOG/INieNfuhQArWeTxyeufsOj8llWEcyYVRVcmJJfjrAagSLuY9OfoNVlSBM2wP92tzQUXQrvHM+mqw"
          + "9gDlhudOnJAyP6iP8bVsqPN1bU="),
  DOT_DARK_GRAY(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTgyODg3MzcsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMD" +
          "Y0OGJlMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3Rl"
          + "eHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9lODQzY2ZjM2ExMmNiNjQ0MWY5NjA5MDIwNjM2NzI2NTdlMDhjNmQ4MzQ0Yj"
          + "UyOGE4NDU5YmQ1MTYyYjJkNDgifX19",
      "nPEbxncNxOm4I6BEsRQ+nsSy5qXKsvKkKLTYHUkze9fQS5JYyiTgAu"
          + "N/ouljx8fBSbEBdFWxFZq68WxF5h3QDIX7O9x2OFtx9L7vURndZ9pACBRJehy2Kt50eLlEeNMfg1z12J0ODQ36fKbujUYK4ad2"
          + "ZkM+IOd+QGRV2EDRqFpKC4NMIiXnQ40RYo5GJBAIuW96kioCvaN7+jbpyKW7ub9RAj7dVlXeBbP7cCYvPHb74Ww/lw/Ehcsbrw"
          + "H92eqrApr/oq0Aa9MoW4FKLsEejXvYFjzn6d44uPddwjkcWnd0B2Z8Z8PU/ajS+ZYQY/RqQKRo72bjjPKmn92A19ULtPTFTSO"
          + "sxxVmLTSSFbYqujt4hUd7BEcDlFcowfhdXtUQWYp1c0DV63UU+dkp8bmnaSCHoG+goyJJN43eqZwSiln2UzEGb+it/wSE3kgsy"
          + "8q2X4pNgx67ZVUW1ZdRomsBIO0WoanuYoeCNXKRzwMj2mygocdlSer5ZmsnvqG8e+zt8j4iytYDRZ9AWu4euHPPYPbWozAUUbq"
          + "zsAkogcqa29Bz0mEbr56Per+4806tmPrg+kheI/pBvqCv+HBMRM5ZEEO9FWkTKl2hvr6t6uTNuXFnlVkwspEJaocE+8JJ0E4WD"
          + "W2mR997uvYYbohY/HPMUG6cK05SwghM9OhQmD8L1Ao="),
  DOT_BLUE(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTYxNzkxNDYsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMDY0OGJ"
          +
          "lMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1c"
          + "mVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS80ZjE1NWRiMmIwZjE1YmIxMThjMmNjZjYyMWI5Y2JlNDBiZjQzODk4ZmZkODRhZjcz"
          + "MmMxNWYzZGNlNWM4In19fQ==",
      "tXZ/NzLISCygr4aGFLVwW6g8lZdoPruN472pVGHepHU+e+spVjOoQQ/vXrIl2"
          + "nO5EZe4yVsXYDGZK7UD8v3pNfjyXdwAdaRplgQy4B71dvpxoookgN6ytbkr3EV0WucsNCpJPVEAWN8P1DGYVU0lVWyqdphfmbqG"
          + "aTQOtJonS95TIbfJvmropA86Uc3s6mCOGceb6+wu216IGOtQ1tnBI7wJJF6p3nYm2hXKPDz/ulZNUb6A17T532hfLNRk7tWaPsj"
          + "zYnKdTFvpVzuVyulfUPz0cxfjQPAreU072/GxKxk2eTlK6qBCT4hOBa+jlnBUUuG8JIL1/HetF5e+"
          + "/f2FnaR8eHaqdJBd/1xaA2jAILNP/Y//4G72BdnMnFsv+rVptE+V+yWzg0Pvlv3I0FqGNc+fZWmP4pqjIUd2T7LjtztV7MyBDEC"
          + "g2ASXRhmaaldjKcZAjgaOyPjYkQ8ydFgPMrQB/xR4yiHnivguJWG9ReuwALI480ZKw5VM4evp6JhvYGBkgnrvC+AKGX+gAZhfAn"
          + "IT+KdUXAJh3LYfy984e1OQQqNCOg+="),
  DOT_LIME(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTgzMjE5NTAsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMDY0OGJ"
          +
          "lMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1c"
          + "mVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9jMGQzODkzMjYyMWI5NTIzZTlkODdjODcxMzEyNTk3ZTU0Y2QyMjRjODQ0NmY2NTE"
          + "0ODY1ODE0Y2RlMzhhMTIifX19",
      "huZ5VsNJVXyj1jijC2KE3rE/XbF47jfj/dApSKRqMbTmHQhi3AEFUAetgN0T"
          + "sBJWaynz/bgADVTY84WsDeeZyW6u1FZHQtOyvq6zxVCw2L1tFrjO7Ts0AYXpNvaZawz+r9OuM01Y62z9oK4VwA7e9oFHDSuo4m"
          + "ExcTgd35cqyxJmqNA2k5xMh88BBiKumJNTenzTEqfQaaWesSmRJWnxZ09zZKhZb2E0m4ekymZPKZWPuxxfOenaFWlpyltLnx/2"
          + "pC7VRkG1v+zoBe/VmfsEtu5qWPPS8UPtg1Fpx+Q3GtxIApGj0Ni/DiKkaOmOY/5HH9uYD4BtJ3NjXEFCWbkQOXEgLrgwdstRVL"
          + "53opC3+07QZTbnXVNA2Ua76Gu6T8j+KMxpA0+q0nS+FQZCL2TEt2Pm9nsAZx43kvQ/iA3hnM1hZ64jSQ4nj38mUJ7bnmqM2bcZ"
          + "pQMtIDzwMwswMLh9/jpYFZBK9p5tG2TW91RjSne6R0sOyzZyfOBX/T8oNohBCSVokD4+8SGyBGzknUb1VE0YOZ5HOj3N7agGxh"
          + "WyPB6DrYCUT8hljtezFO+iPBSBLVo2yuX1PMrrQYB9ir+rTc7mjOYWmL6ENrkSN52fBDCd4yLhPZyU0AP4ov+Nl175c32e5f8"
          + "Ihhz7IRnVhNDzOE12WS55ynn1IofblMSgfPU="),
  DOT_LIGHT_BLUE(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTgzNDc3NjIsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyM" +
          "DY0OGJlMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3R"
          + "leHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS83YWQzYTk4NmU4N2E3ZDZjMzk5MTNjNmM5MmE1MmNkNTI0MmUyNmU2ZDc4N"
          + "zRhYzVkYmFiMDdkODNiYzE4NCJ9fX0=",
      "QwTBMrsbG4EGg5GnaYGyWy5S6G7UWJTTafe/22OMDEsmIy2mcaPzTR"
          + "HdxQjeWPa8Zk5wGlp7ehZMbC262DRdDG5Wg7SKuAkxNdow/u8BhrUJg4Z9nQhfOauoN2tk/F1j+isV+xVi58EsEhhsr9h/1s9v"
          + "xJKI2GBJJUmTjZ8xzYmcsihpoM4LaHKRu8sXWQ1MHa5QBgqzOy8UPRabFFNg/5GT8xo0UqM/5FlsYMdiIPsEdOi5bMPsU6ZTco"
          + "/hWpqTMAlhDMw3hLUxvknnQ6Pf1Mi6GOqTSucaKggAyrj++p9LMtihwBOvRHhWUfIPTKdZ05JllS8Q6aZioOqVbsd+GLHYZp/P"
          + "KtwKNC62rPzpqZMIBw3HgZ5ciQhSmDMr/l2dDUKEn/LIAJew9P+GXVEpPTAJSLy2IkcEKzrtU5ZSTmbZwzzldviK0+tPVCE3AzM"
          + "cnYqoVbj4uOpo9Uo/uaunLWm8/PWcjRw3qy8c3czxC1xVynEDA5J6wjo8oqjSnEOuHuJ6cFLCYUf4QMlRmVIaA4lllAOOr+68Q"
          + "EHzek+DRc6rNgkUoqCcHF53YCfH7JItpSxxTZ6snFS2LI20KFUp93DibVEkxifkyQLbqB1OAcyDXkji8HJ7IKUMAUKoNFpLL5e"
          + "ANJsv/96P81N16rGA3THLe5iz17L5xVX/hpruKAo="),
  DOT_RED(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTgzNjk3OTUsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMDY0OG"
          +
          "JlMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR"
          + "1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84OGNiOTNlOTgwZjYyOTMxMzYwNGNkMzMzODEzOTRjNTA5ZjljMTIxOGRjMjYy"
          + "M2Q2NTBlZmI4ZjNkMjAifX19",
      "FqA2ErdpdSPLYrb+O0O1i5dxEr9ZD7ZhaeiSZmU8QSf6+yA8eGo+KZo0N7E"
          + "HC6YFXnxkgySFqJYk7itcHQ5bLRKpKCaSKAXP4XX5a94/7x6lNa8ev82L+Er3A/mH/0cllxmngqLY5vK8Hej09NoMMNNAhtp+"
          + "f07TkqLPCi3J6G4mFK4zHAId1gEIEyj7JxlTDeOeU0MRUE4bbngyt2h5VsGpitFaYWJZTSnl8XsXr+6/diXk1nM9smKmmwIv8"
          + "C02Ufdw3N4/fB93qWfuDUmpd4RLck6XJpp8qJ95twQTmdlpEkUtTt258mHnCV/pjMY9T0J7R1MDbYajkfhDQ1xIdKpVZEsYr"
          + "oEVv4jNOedbRHccF5XZLG7QcYGUk22A53XT0/zuyIBfQbYk/XShABdIHoNW+PNscrtahAmqqGmxkxQqZdI7DdB6V4f5J2YpLk"
          + "t6k/nXvV1uA+Gm2uPylPvvJusVJJD0Z+BroyM4SsXFfaN9oAqGmNFMdIWR+17vl9TZmfN+K3KodMeiSTcVNUFKVAtMFXSaz80"
          + "UzmKAB1D+EsZQrJ/Qzo4+OP52TwMmlLOBUY3TvgZkJrK+2MC5kGnwJlW3atjR8JlsKTdNJx/xoCg8HRbaqdxQAfz7zYBRnYfF"
          + "euf9Uvb0G7RW33CO0ifqP0gi9HUoQH3LxAiJ0zNqh+o="),
  DOT_PINK(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTgzODM4OTUsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMDY0O"
          +
          "GJlMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleH"
          + "R1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9lN2E3ZmY2M2RjZDU4NWM0YzZmNjM4OWI0ODZlMzBkNjg0MjE2NGZjNDRlOT"
          + "Q2N2I4OWM0ZTFjZTZjMzg2OWY5In19fQ==",
      "HMmoTUZECnTE/LoW4y4+yH7YENNOHqFdhYPFmULfFsEYjU/cY"
          + "0eUu2LmlFcfjox0RTHqGebR0OmGnfVgim/p6n1RQtOXW0dt3GZKgrU10LPGRvEwQ6SMAB9/o5qKL+tnNDAtzbgrUJQh6kQGI"
          + "7EU89h1KWeUpXmksPhnAPTvuXhFYEj467Ocg5Jz+CT1n8x4Gu0lXI8v8jHW+G/KP2JSQkLeLkqVRb8dGs9laFRvVwXQ3zLgT"
          + "FgksgwGnuSlWTxoKVS//oLjwlZtiSowg1g+mQJJZxoH8esfAFGsxNKV+7JrdN13PfCkbdZYDpm5eom4SdrSflP3DXCBuGvBS"
          + "FoStDYYegZEY5t7GhRizubZOU8ze3hfnbU8HqXZH4wqvmHzH7PhM6edQUrgJ+j9HV5jfpV9fQ9vhtlAFg9x1s9V8+yxpQ82"
          + "7FIqwyR4LY5cVZHyQCl1vkeCSuImrIUmYZ3ZsbQXzODDlzLEox++YDiEnUeuRCdJi4MInO9oKbZnZltEO4fsyWj7dRgQZQK"
          + "WCR+iXaWiGsNmiiJiishn2+dEjFGg0L0pG6KE4XmkCJtDX2VvvgK3q4e9a0mZucZn68SjV3CcBghXkZ31pKzxxaQrKQoxs1KZ"
          + "FfG2UL7QDGmUURZxwWYzOo6KhI9eyAx41mujy8xlzarQzUErN4cwoFoPSmA="),
  DOT_YELLOW(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTg0MDE0NzAsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMDY0" +
          "OGJlMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3Rle"
          + "HR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8zYzY2ZDFmMDhkZmRmZTY2ZjljZDExYjA1MmY0YzM1YTdkMjk0MWZmMjNhOT"
          + "RjY2UyM2Y3ZjgyMTg1NzcyZDgifX19",
      "Rs2GuNrHjFBLk09ymZ/3UpTNSbbjmnZ3WvzA8n0X0gwzNHAx+8u/pN"
          + "WO2uMEW1TZE5fhmrRAb8krfEpr/D5RdeXl+Se7NRch4mxpWqz4jiipMigFgGnf/s0JY+/dn5amGnoHKzqsktHFx3qwwOjGaz2"
          + "jj1vhysuzQLGptnurn9wnRgVIueWfR2Cctc0v1pJ9jBVx/gkG3N+2Wznml+50pphxhcYBtfUKtwnMRxHIOz0me1KuRhqmBtmM"
          + "zoQUArJXiz7cAX8cRlTqUg2ilY4UYLxNsH3cyaJi//tOzpk7EEwo2W1vYT/ZqiHTUvDBeRSu4Or9YZ7TwF/klbSnZJqaC2X0d"
          + "u00QcaoGAvFPY+A9HXZ3QII7k4g0M+aI3huiDUQX24O3p9h4J4dKJpktq1FH0G271uf5m3DMQlAQHTJWP07r3rL/23hAALMtI"
          + "jE4SvUANd+WBxAeAlgSQamWk2YKQv/TxnNlr6tZMKOz/L1xsXJdn4eATWO786wH5IlxHKwgIQnmEYPSZX3AYsGtIsYuQhttbjmqY"
          + "iecNdywXy6/WpZwhUHWW2aKuvkczJ8kX5Mcq+viVQRWRJNsCwqwzeXMLEX5tpNGOlQAyRJ/lyGUYJKmEXyqWXIxJstbJG09OR/"
          + "G9V53ZhNa1hEaaVGv1FwZ9WdH1xHhGyJySz9JtrmKQ0="),
  DOT_WHITE(
      "eyJ0aW1lc3RhbXAiOjE0NTI0MTg0MjUyNTQsInByb2ZpbGVJZCI6ImU4MjYwM2RmNDE3ZDRhOTViZDFmMTcyMDY0" +
          "OGJlMGI0IiwicHJvZmlsZU5hbWUiOiJQYWJsZXRlMTIzNCIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3Rl"
          +
          "eHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9jMWViNWQ1MzExZjI1YjQ5MmEyMTIyYWM0YTNkYWUzZjNiMmRmNTc1NmFj"
          +
          "YWM4ZjVjYjk2NWEyYjhjMGY4In19fQ==",
      "LHeNKZWS3u7hmMmxqjEiCLAlhHRR4ZzQDZkCwJNid0odX38Qm98" +
          "teyCwg4VmYKUrovIpqX3xReYiZ2LIY2SQDz6nARj6qarHQHDMgZ6Itqfd8jue5ZlzbwRwv9Fmirxdq67yA/VAMmy7Hel60X3"
          +
          "9PF/qVlVmA1k9nFz2NDmMlASA61nI2oEjfvdwRgODAG0rSkocIqxpZ8y/hUAsUsP2NPISIRl+yY+QLpzkx56+iTvLvYsYbhF"
          +
          "MMJyjshjgL6j/TH9XRyjfqxfthTiKrH7zYSbxIb1nQC+Osrzg2EN9M2BPfyvF/MiFsQGu8It9CXSSR6ZFqTnDmhteFySiOrC"
          +
          "8WF6F6rZL+vMYLSgke4vixLFLLdgdb1NBBMy8wGfEJFfLGs0n7UcnHERLg8ZTzz3yov6vKVd5dqv8uClQGHbv4iHVpvvepZ8"
          +
          "BUuPH4PQgxqhs1akQ/q9B0RVXucigEcQMWfBAftGEDUI9PL17jjjsNbLYnX7yjSV3AWi3PPFVs7JWXrG+9KQPYHO1OuoA0ld"
          +
          "3gA50+nSRXqcpDrvxRqo88MlqAv54Wc/I/lYOfpzx9BCgQsMz7n6wq22BsGLhNdbB+Usw/GB8s50KDZ91Zigc2REljgyoabz"
          +
          "NBMHa/ACaPiBuFZ8ApBd84no+ipnpVJXnNcFxSH44AShuIcZaCdBlwbw=");

  private final String value;
  private final String signature;

  TablistHead(String value, String signature) {
    this.value = value;
    this.signature = signature;
  }

  public String getSignature() {
    return signature;
  }

  public String getValue() {
    return value;
  }

  public Player asPlayer(String name, String tablistName) {
    return PlayerBuilder.ofName(name, tablistName, this.value, this.signature).build();
  }
}
