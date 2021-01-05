var app = new Vue({
    el: "#app",
    data: {
        message: "Hello Springboot!",
        Janu: '',
        date: '',
        fileList: [],
        a_fileList: [],
    },
    mounted() {
    },
    methods: {
        async onlinePreview() {
            //要预览文件的访问地址
            let res = await fetch("minio/presigned", {
                method: 'get'
            }).then(res => res.json());
            console.log(res);
            let originUrl = res.data; //要预览文件的访问地址
            console.log(originUrl);
            let previewUrl = originUrl + '&fullfilename=aaa.docx';
            console.log(previewUrl);
            window.open('http://localhost:8012/onlinePreview?url=' + encodeURIComponent(previewUrl));
        },
        _changeFile(event) {
            let a = event.target.files;
            console.log(a);
            console.log(a[0]);
            this.a_fileList.push(a[0]);
            console.log(this.a_fileList)
        },
        async _upload() {
            let fd = new FormData()
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
