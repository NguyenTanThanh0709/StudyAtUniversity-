def zodiac_sign(day, month):
    
    if month == 'december':
        astro_sign = 'Sagittarius' if (day < 22) else 'capricorn'
         
    elif month == 'january':
        astro_sign = 'Capricorn' if (day < 20) else 'aquarius'
         
    elif month == 'february':
        astro_sign = 'Aquarius' if (day < 19) else 'pisces'
         
    elif month == 'march':
        astro_sign = 'Pisces' if (day < 21) else 'aries'
         
    elif month == 'april':
        astro_sign = 'Aries' if (day < 20) else 'taurus'
         
    elif month == 'may':
        astro_sign = 'Taurus' if (day < 21) else 'gemini'
         
    elif month == 'june':
        astro_sign = 'Gemini' if (day < 21) else 'cancer'
         
    elif month == 'july':
        astro_sign = 'Cancer' if (day < 23) else 'leo'
         
    elif month == 'august':
        astro_sign = 'Leo' if (day < 23) else 'virgo'
         
    elif month == 'september':
        astro_sign = 'Virgo' if (day < 23) else 'libra'
         
    elif month == 'october':
        astro_sign = 'Libra' if (day < 23) else 'scorpio'
         
    elif month == 'november':
        astro_sign = 'scorpio' if (day < 22) else 'sagittarius'
         
    print(astro_sign)
     


day = 19
month = "may"
zodiac_sign(day, month)