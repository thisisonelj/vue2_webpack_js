//数组去重
interface arrayObj {
  value: string;
  label: string;
}
const arrayDeduplication: (
  souceArray: Array<arrayObj>,
  currentArray: Array<arrayObj>,
) => Array<arrayObj> = (source, current = []) => {
  const obj: Map<string, arrayObj> = new Map();
  source.forEach((element) => {
    if (!obj.has(element.value)) {
      obj.set(element.value, element);
    }
  });
  current = [...obj.values()];
  return current;
};
const commonObject = { arrayDeduplication: arrayDeduplication };
export default commonObject;
