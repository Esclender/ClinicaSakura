/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/main/resources/templates/**/*.{html,js}"],
  theme: {
    extend: {
      colors: {
        'light-bg-color': '#FFFFFF99',
        'letters-color': '#271E4A',
        'button-color': '#CA79C6',
        'tb-head': '#EDF4FC',
        'tb-letter-row': '#3F779B',
        'red-container': '#CF7979',
        'green-container': '#79CFA6',
      },
      backgroundImage: theme => ({
        'custom-gradient': 'linear-gradient(to bottom right, #DBD2FC, #DBD2FC 10%, #FDE2E0 28%, #E6E4EA 59%, #E6E1EB 100%, #E0E9F4)',
      }),
      boxShadow: {
        'lile-shadow': '0px 4px 15px rgba(219, 210, 252, 0.64)',
      },
      fontFamily: {
        'kanit': ['Kanit', 'sans-serif'],
      },
    },

  },
  plugins: [],
}

