# 🌿 ChimpiNature v1.0.0

Mod para **Minecraft Java 1.20.1**, usando **Fabric** e Java 17

## Recursos
- 🌪️ Vento ambiente: particulas e folhas em movimento, com quatro intensidades ajustadas pela tecla **V**
- 🍔 Sanduiche, salada de frutas e torrada com mel, com receitas de crafting
- ✨ Shaderpack opcional para efeitos de vento na vegetacao, disponivel separadamente
- 🇧🇷 Português e inglês

## Downloads

Veja os arquivos da versao na aba [Releases](https://github.com/Chimpi-hackintosh/ChimpiNature/releases)

O workflow `Build e Release do ChimpiNature` compila usando Gradle e disponibiliza os arquivos como artefatos. Pushes em `main` e pull requests não publicam Releases

A Release v1.0.0 só é criada ou atualizada quando o mantenedor executa **Actions → Build e Release do ChimpiNature → Run workflow** e marca explicitamente `publish_release`. O padrão é desmarcado
- `ChimpiNature-1.0.0.jar` (mod Fabric)
- `ChimpiNature_Shaderpack.zip` (shader opcional)

## Instalação

1. Instale Minecraft Java **1.20.1** e **Fabric Loader**
2. Instale **Fabric API** compatível
3. Coloque `ChimpiNature-1.0.0.jar` em `.minecraft/mods`
4. Se quiser shaders, instale **Iris Shaders** para 1.20.1 e coloque `ChimpiNature_Shaderpack.zip` em `.minecraft/shaderpacks`
5. Entre no jogo e aperte **V** para alternar o vento

**Aviso:** O shaderpack é opcional e não foi testado no jogo; o código do mod precisa ser validado em Minecraft real

## Compilar localmente

Instale JDK 17 e Gradle 8.8, depois execute:

```sh
gradle build
```

Arquivo esperado: `build/libs/ChimpiNature-1.0.0.jar`

## Receitas

| Item | Ingredientes |
| --- | --- |
| Sanduiche (2) | 2 pães, 2 cenouras, 1 carne bovina cozida |
| Salada de frutas (1) | 1 maçã, 1 melancia fatiada, 1 fruta silvestre doce, 1 tigela |
| Torrada com mel (2) | 1 pão, 1 frasco de mel |

MIT License © 2026 ChimpiNature Contributors
