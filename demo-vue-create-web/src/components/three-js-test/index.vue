<template>
  <div class="three-js-container" id="threeId"></div>
</template>
<script>
export default {
  data() {
    return {
      title: "练习three.js项目",
    };
  },
  mounted() {
    this.initGraph3DInfo();
  },
  methods: {
    initGraph3DInfo() {
      const scene = new this.$threeApi.Scene();
      const camera = new this.$threeApi.PerspectiveCamera(
        75,
        window.innerWidth / window.innerHeight,
        0.1,
        1000
      );
      const renderer = new this.$threeApi.WebGLRenderer({ antialias: true });

      renderer.setSize(window.innerWidth, window.innerHeight);

      renderer.setClearColor("#222222");
      document.getElementById("threeId").appendChild(renderer.domElement);
      camera.position.z = 5;

      // resize 事件
      window.addEventListener("resize", () => {
        let width = window.innerWidth;
        let height = window.innerHeight;
        renderer.setSize(width, height);
        camera.aspect = width / height;
        camera.updateProjectionMatrix();
      });

      // 立体方
      const geometry = new this.$threeApi.BoxGeometry(1, 1, 1);
      const material = new this.$threeApi.MeshStandardMaterial({
        color: 0xff0051,
        flatShading: true,
        metalness: 0,
        roughness: 1,
      });
      const cube = new this.$threeApi.Mesh(geometry, material);
      scene.add(cube);

      // 维数据集
      const geometry2 = new this.$threeApi.BoxGeometry(3, 3, 3);
      const material2 = new this.$threeApi.MeshBasicMaterial({
        color: "#dadada",
        wireframe: true,
        transparent: true,
      });
      const wireframeCube = new this.$threeApi.Mesh(geometry2, material2);
      scene.add(wireframeCube);

      // 环境光
      const ambientLight = new this.$threeApi.AmbientLight(0xffffff, 0.2);
      scene.add(ambientLight);

      // 点光源
      const pointLight = new this.$threeApi.PointLight(0xffffff, 1);
      pointLight.position.set(25, 50, 25);
      scene.add(pointLight);

      function animate() {
        requestAnimationFrame(animate);
        cube.rotation.x += 0.04;
        cube.rotation.y += 0.04;
        wireframeCube.rotation.x -= 0.01;
        wireframeCube.rotation.y -= 0.01;
        renderer.render(scene, camera);
      }
      animate();
    },
  },
};
</script>
<style scoped>
.three-js-container {
  height: 100%;
  width: 100%;
  overflow: hidden;
}
</style>
