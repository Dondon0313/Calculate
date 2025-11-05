//      可被列印的 (Printable) 介面
//      這是一個「合約」，它規定任何實作(implements)此介面的類別，
//      都必須提供一個 showInfo() 方法。

public interface Printable {

    // 介面中的方法預設就是 public abstract (公開、抽象的)
    // 所以 "public abstract" 可以省略不寫
    void showInfo();
}
