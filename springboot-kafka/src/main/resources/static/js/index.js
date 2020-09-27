var app = new Vue({
  el: "#app",
  data: {
    message: "Hello Springboot!",
    Janu: '',
    date: '',
  },
  mounted() { },
  methods: {
    getDate() {
      let date = new Date();
      let month = date.getMonth() + 1;
      month = month.toString().padStart(2, "0");
      return date.getFullYear() + "-" + month;
    },
    async post() {
      var param = {};
      fetch(url, {
        headers: { contentType: "application/json;utf8" },
        method: "post",
        body: JSON.stringify(param),
      })
        .then((s) => {
          let result = s.date;
          if (result.code === 1) {
            console(result.message);
            return result.message;
          }
        })
        .catch(function (error) {
          alert(error);
        });

      let mesaage = await fetch(url, {
        headers: { contentType: "application/json;utf8" },
        method: "post",
        body: JSON.stringify(param),
      }).then((s) => s.json());
    },
  },
});
