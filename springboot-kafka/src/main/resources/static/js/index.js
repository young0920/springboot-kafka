var app = new Vue({
    el: "#app",
    data: {
        message: "Hello Springboot!",
        Janu: '',
        date: '',
        fileList: [],
        a_fileList: [],
        apiToken: ''
    },
    mounted() {
        this.getToken();
        this.testAxios();
    },
    methods: {
        async testAxios() {
            let res = await axios({
                method: 'get',
                url: 'submit/token'
            });
            console.log(res);
        },
        async getToken() {
            let res = await fetch("submit/token", {
                method: 'get'
            }).then(res => res.json());
            this.apiToken = res.data;
        },
        async testSubmitRepeat() {
            setTimeout(async () => {
                let res = await fetch("submit/header", {
                    method: 'get',
                    headers: {
                        token: this.apiToken
                    }
                }).then(res => res.json());
                if (res.code === '00000') {
                    this.apiToken = res.data;
                } else {
                    alert(res.message);
                }
                console.log('等待两秒');
            }, 2000);
        },
        async onlinePreview() {
            //要预览文件的访问地址
            let res = await fetch("minio/presigned", {
                method: 'get'
            }).then(res => res.json());
            let url = res.data; //要预览文件的访问地址
            // let previewUrl = originUrl + '&fullfilename=aaa.pdf';
            //btoa base64加密   atob解密
            open('http://localhost:8012/onlinePreview?url=' + btoa(url));
        },
        _changeFile(event) {
            let a = event.target.files;
            console.log(a);
            console.log(a[0]);
            this.a_fileList.push(a[0]);
            console.log(this.a_fileList)
        },
        async _upload() {
            let fd = new FormData();
            this.a_fileList.map((item, index) => {
                fd.append('file' + index, item);
            });
            let res = await fetch("file/upload", {
                method: 'post',
                body: fd
            }).then(res => res.json());

            console.log(res);

        },
        submitUpload() {
            this.$refs.upload.submit();
        },
        //移除方法
        handleRemove(file, fileList) {
            console.log(file, fileList);
        },
        changeFile(file, fileList) {
            console.log(file);
            console.log(fileList);
        },
        uploadSuccess(response, file, fileList) {
            console.log(response);
            console.log(file);
            console.log(fileList);
        },
        //预览方法
        handlePreview(file) {
            console.log(file);
        },
        getDate() {
            let date = new Date();
            let month = date.getMonth() + 1;
            month = month.toString().padStart(2, "0");
            return date.getFullYear() + "-" + month;
        },
        async post() {
            var param = {};
            fetch(url, {
                headers: {contentType: "application/json;utf8"},
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
                headers: {contentType: "application/json;utf8"},
                method: "post",
                body: JSON.stringify(param),
            }).then((s) => s.json());
        },
    },
});
